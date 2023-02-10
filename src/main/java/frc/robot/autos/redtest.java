package frc.robot.autos;


import java.util.HashMap;
import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve;

public class redtest {

    Swerve swerve;
    Subsystem[] subsystems;
    SwerveAutoBuilder builder;

    public redtest(Swerve swerve) {
        this.swerve = swerve;
        subsystems = new Subsystem[]{swerve};
        this.builder = new SwerveAutoBuilder(
            swerve::getPose, 
            swerve::resetOdometry, 
            Constants.Swerve.swerveKinematics, 
            new PIDConstants(0.05, 0, 0),
            new PIDConstants(0.05, 0, 0), 
            swerve::setModuleStates, 
            new HashMap<>(), 
            subsystems
            );
    }
    
    public CommandBase getAuto(){
        PathPlannerTrajectory testPath = PathPlanner.loadPath("Red Auton 3", new PathConstraints(4, 3));
        return builder.followPath(testPath);
    }

    // This will load the file "Example Path.path" and generate it with a max velocity of 4 m/s and a max acceleration of 3 m/s^2
    
}

