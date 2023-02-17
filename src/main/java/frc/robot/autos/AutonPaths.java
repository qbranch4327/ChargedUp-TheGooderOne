package frc.robot.autos;

import java.util.ArrayList;
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
    IntakeSubsystem intakeSub;
    VomitCommand vomit;
    AutonIntakeCommand intake;    
    String path;
    String[] paths = {
        "Blue Auton 1",
        "Blue Auton 1 PLATFORM", 
        "Blue Auton 2 BOTTOM CUBE",
        "Blue Auton 2 TOP CUBE", 
        "Blue Auton 2 DOWN",
        "Blue Auton 2 MIDDLE",
        "Blue Auton 2 UP",
        "Blue Auton 3",
        "Blue Auton 3 PLATFROM",
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
    

    public AutonPaths(Swerve swerve, IntakeSubsystem intakeSub) {
        this.swerve = swerve;
        this.intakeSub = intakeSub;
        vomit = new VomitCommand(intakeSub); 
        intake = new AutonIntakeCommand(intakeSub, null);
        subsystems = new Subsystem[]{swerve, intakeSub};
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
    
    public CommandBase getAuto(int index){
        PathPlannerTrajectory pathTrajectory = PathPlanner.loadPath(paths[index], new PathConstraints(4, 3));
        
        HashMap<String, Command> eventMap = new HashMap<>();
        eventMap.put("vomitCargo", vomit);
        eventMap.put("intakeCone", intake);

        FollowPathWithEvents command = new FollowPathWithEvents(
            builder.followPath(pathTrajectory),
            pathTrajectory.getMarkers(),
            eventMap
        );

        return command;
    }

    // This will load the file "Example Path.path" and generate it with a max velocity of 4 m/s and a max acceleration of 3 m/s^2
    
}

