package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class DockCommand extends CommandBase{
    
    Swerve swerve;
    boolean docked = false;
    boolean start = false ;

    public DockCommand(Swerve swerve)    {
        this.swerve = swerve;
    }

    @Override
    public void initialize() {
        start = false;
    }

    @Override
    public void execute() {
        
        if (!start){
            swerve.drive(false);
        }
        if (swerve.getRoll() > 13)    {
            swerve.slowDown(false);
            start = true;
        }
    }

    @Override
    public boolean isFinished(){
        if (swerve.getRoll() < 12 && start)    {
            swerve.xStance();
            start = false;
            return true;
        }
        else{
            return false;
        }
    }
}
