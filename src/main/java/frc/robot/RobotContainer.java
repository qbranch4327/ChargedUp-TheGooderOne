package frc.robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.SwerveAutoBuilder;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final XboxController driver2 = new XboxController(1);
    private final ElevatorSubsystem eSub;
    private final TiltSubsystem tSub;
    private final IntakeSubsystem iSub;
    private final SpinnerSubsystem sSub;
    //private final VisionSubsystem vision;

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;
    Command vCommand;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    // private final PathPlannerTest pathPlannerTest;

    /* Paths */
    private final pathBuilder pathBuilder;
    private static final String[] paths = {
        // "TEST",
        "Blue Auton 1",
        "Blue Auton 1 PLATFORM", 
        "Blue Auton 2 BOTTOM CUBE",
        "Blue Auton 2 TOP CUBE", 
        "Blue Auton 2 DOWN",
        "Blue Auton 2 MIDDLE",
        "Blue Auton 2 UP",
        "Blue Auton 3",
        "Blue Auton 3 PLATFORM",
        "Red Auton 1",
        "Red Auton 1 PLATFORM",
        "Red Auton 2 BOTTOM CUBE",
        "Red Auton 2 TOP CUBE",
        "Red Auton 2 DOWN",
        "Red Auton 2 MIDDLE",
        "Red Auton 2 UP",
        "Red Auton 3",
        "Red Auton 3 PLATFORM"
        };

    SendableChooser<Command> qChooser = new SendableChooser<>();

    Command autoTest;

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        this.eSub = new ElevatorSubsystem();
        this.tSub = new TiltSubsystem();
        this.iSub = new IntakeSubsystem();
        this.sSub = new SpinnerSubsystem();
        //this.vision = new VisionSubsystem();
        this.pathBuilder = new pathBuilder(s_Swerve, iSub, sSub);
        

        // FOR USE WITH OLD PATHBUILDER ONLY //
        
        // Automatically adds paths from the paths array. The path name at index 0 is set to the default.
        // qChooser.setDefaultOption(paths[0], pathBuilder.getAuto(paths[0]));
        // for(int i = 1; i < paths.length; i++)  {
        //     qChooser.addOption(paths[i], pathBuilder.getAuto(paths[i]));
        // }
        
        ArrayList<PathPlannerTrajectory> pathGroup = (ArrayList<PathPlannerTrajectory>) PathPlanner.loadPathGroup("Red Auton 2 MIDDLE", new PathConstraints(4, 3));

        // This is just an example event map. It would be better to have a constant, global event map
        // in your code that will be used by all path following commands.
        HashMap<String, Command> eventMap = new HashMap<>();
        eventMap.put("vomitCargo", new VomitCommand(iSub, sSub));
        eventMap.put("elevatorCommand", new AutonElevatorCommand(eSub));

        // Create the AutoBuilder. This only needs to be created once when robot code starts, not every time you want to create an auto command. A good place to put this is in RobotContainer along with your subsystems.
        SwerveAutoBuilder autoBuilder = new SwerveAutoBuilder(
            s_Swerve::getPose, // Pose2d supplier
            s_Swerve::resetOdometry, // Pose2d consumer, used to reset odometry at the beginning of auto
            Constants.Swerve.swerveKinematics, // SwerveDriveKinematics
            new PIDConstants(0.05, 0.0, 0.0), // PID constants to correct for translation error (used to create the X and Y PID controllers)
            new PIDConstants(0.05, 0.0, 0.0), // PID constants to correct for rotation error (used to create the rotation controller)
            s_Swerve::setModuleStates, // Module states consumer used to output to the drive subsystem
            eventMap,
            true, // Should the path be automatically mirrored depending on alliance color. Optional, defaults to true
            s_Swerve // The drive subsystem. Used to properly set the requirements of path following commands
        );

        autoTest = autoBuilder.fullAuto(pathGroup);

        SmartDashboard.putData(qChooser);

        vCommand = new VomitCommand(iSub, sSub);

        eSub.setDefaultCommand(new ElevatorCommand(eSub, tSub, driver2));
        iSub.setDefaultCommand(new IntakeCommand(iSub, sSub, driver2, driver));

        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean(),
                driver
            )
        );

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        // return qChooser.getSelected();
        return autoTest;
    }
}
