package frc.robot;

import org.opencv.objdetect.QRCodeDetector;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    //private final GripSubsystem gSub;
    private final IntakeSubsystem iSub;
    private final SpinnerSubsystem sSub;
    //private final VisionSubsystem vision;

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    // private final PathPlannerTest pathPlannerTest;

    /* Paths */
    private final AutonPaths blue1;
    private final AutonPaths blue1Plat;
    // private final AutonPaths blue2BCube;
    // private final AutonPaths blue2TCube;
    // private final AutonPaths blue2Down;
    // private final AutonPaths blue2Mid;
    // private final AutonPaths blue2Up;
    // private final AutonPaths blue3;
    // private final AutonPaths blue3Plat;
    // private final AutonPaths red1;
    // private final AutonPaths red1Plat;
    // private final AutonPaths red2BCube;
    // private final AutonPaths red2TCube;
    // private final AutonPaths red2Down;
    // private final AutonPaths red2Mid;
    // private final AutonPaths red2Up;
    // private final AutonPaths red3;
    // private final AutonPaths red3Plat;

    SendableChooser<Command> qChooser = new SendableChooser<>();


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        this.eSub = new ElevatorSubsystem();
        this.tSub = new TiltSubsystem();
        this.iSub = new IntakeSubsystem();
        this.sSub = new SpinnerSubsystem();
        //this.vision = new VisionSubsystem();
        // pathPlannerTest = new PathPlannerTest(s_Swerve, iSub);
        blue1 = new AutonPaths(s_Swerve, iSub);
        blue1Plat = new AutonPaths(s_Swerve, iSub);
        // blue2BCube = new AutonPaths(s_Swerve, iSub);
        // blue2TCube = new AutonPaths(s_Swerve, iSub);
        // blue2Down = new AutonPaths(s_Swerve, iSub);
        // blue2Mid = new AutonPaths(s_Swerve, iSub);
        // blue2Up = new AutonPaths(s_Swerve, iSub);
        // blue3 = new AutonPaths(s_Swerve, iSub);
        // blue3Plat = new AutonPaths(s_Swerve, iSub);
        // red1 = new AutonPaths(s_Swerve, iSub);
        // red1Plat = new AutonPaths(s_Swerve, iSub);
        // red2BCube = new AutonPaths(s_Swerve, iSub);
        // red2TCube = new AutonPaths(s_Swerve, iSub);
        // red2Down = new AutonPaths(s_Swerve, iSub);
        // red2Mid = new AutonPaths(s_Swerve, iSub);
        // red2Up = new AutonPaths(s_Swerve, iSub);
        // red3 = new AutonPaths(s_Swerve, iSub);
        // red3Plat = new AutonPaths(s_Swerve, iSub);

        // qChooser.setDefaultOption("test", pathPlannerTest.getAuto());
        qChooser.setDefaultOption("Blue Auton 1", blue1.getAuto(0));
        qChooser.addOption("Blue Auton 1 Platform", blue1Plat.getAuto(1));
        // qChooser.addOption("Blue Auton 2 Bottom Cube", blue2BCube.getAuto(2));
        // qChooser.addOption("Blue Auton 2 Top Cube", blue2TCube.getAuto(3));
        // qChooser.addOption("Blue Auton 2 Down", blue2Down.getAuto(4));
        // qChooser.addOption("Blue Auton 2 Middle", blue2Mid.getAuto(5));
        // qChooser.addOption("Blue Auton 2 Up", blue2Up.getAuto(6));
        // qChooser.addOption("Blue Auton 3", blue3.getAuto(7));
        // qChooser.addOption("Blue Auton 3 Platform", blue3Plat.getAuto(8));
        // qChooser.addOption("Red Auton 1", red1.getAuto(9));
        // qChooser.addOption("Red Auton 1 Platform", red1Plat.getAuto(10));
        // qChooser.addOption("Red Auton 2 Bottom Cube", red2BCube.getAuto(11));
        // qChooser.addOption("Red Auton 2 Top Cube", red2TCube.getAuto(12));
        // qChooser.addOption("Red Auton 2 Down", red2Down.getAuto(13));
        // qChooser.addOption("Red Auton 2 Middle", red2Mid.getAuto(14));
        // qChooser.addOption("Red Auton 2 Up", red2Up.getAuto(15));
        // qChooser.addOption("Red Auton 3", red3.getAuto(16));
        // qChooser.addOption("Red Auton 3 Platform", red3Plat.getAuto(17));

        SmartDashboard.putData(qChooser);

        eSub.setDefaultCommand(new ElevatorCommand(eSub, tSub, driver2));
        iSub.setDefaultCommand(new IntakeCommand(iSub, sSub, driver2, driver));
        sSub.setDefaultCommand(new SpinnerCommand(sSub, driver2));

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
        return qChooser.getSelected();
    }
}
