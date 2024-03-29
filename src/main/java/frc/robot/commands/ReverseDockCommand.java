package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import com.ctre.phoenix.sensors.WPI_Pigeon2;

public class ReverseDockCommand extends CommandBase{
    
    Swerve swerve;
    boolean docked = false;
    boolean start = false ;

    public ReverseDockCommand(Swerve swerve)    {
        this.swerve = swerve;
    }

    @Override
    public void initialize() {
        start = false;
    }

    @Override
    public void execute() {
        
        if (!start){
            swerve.drive(true);
        }
        if (swerve.getRoll() < -13)    {
            swerve.slowDown(true);
            start = true;
        }
    }

    @Override
    public boolean isFinished(){
        if (swerve.getRoll() > -12 && start)    {
            swerve.xStance();
            start = false;
            return true;
        }
        else{
            return false;
        }
    }
}
