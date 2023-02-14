package frc.robot.autos;

import java.util.HashMap;
import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import com.pathplanner.lib.commands.FollowPathWithEvents;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutonPaths {

    Swerve swerve;
    Subsystem[] subsystems;
    SwerveAutoBuilder builder;
    IntakeSubsystem intakesub;
    VomitCommand vomit;
    AutonIntakeCommand intake;    
    String path;

    public AutonPaths(Swerve swerve, IntakeSubsystem intakesub, String path) {
        this.swerve = swerve;
        this.intakesub = intakesub;
        this.path = path;
        vomit = new VomitCommand(intakesub); 
        intake = new AutonIntakeCommand(intakesub, null);
        subsystems = new Subsystem[]{swerve};
        this.builder = new SwerveAutoBuilder(
            swerve::getPose, 
            swerve::resetOdometry, 
            Constants.Swerve.swerveKinematics, 
            new PIDConstants(0.05, 0, 0),
            new PIDConstants(0.05, 0, 0), 
            swerve::setModuleStates, 
            new HashMap<>(), 
            // true,
            subsystems
            );
    }
    
    public CommandBase getAuto(){
        PathPlannerTrajectory testPath = PathPlanner.loadPath(path, new PathConstraints(4, 3));
        
        HashMap<String, Command> eventMap = new HashMap<>();
        eventMap.put("vomitCargo", vomit);
        eventMap.put("intakeCone", intake);

        FollowPathWithEvents command = new FollowPathWithEvents(
            builder.followPath(testPath),
            testPath.getMarkers(),
            eventMap
        );

        return command;
    }

    // This will load the file "Example Path.path" and generate it with a max velocity of 4 m/s and a max acceleration of 3 m/s^2
    
}

