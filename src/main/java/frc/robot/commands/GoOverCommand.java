package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class GoOverCommand extends CommandBase {
    
    Swerve swerve;
    boolean started = false;
    boolean wentOver = false;
    boolean returning = false;

    public GoOverCommand(Swerve swerve)  {
        this.swerve = swerve;
    }

    @Override
    public void initialize() {
        swerve.drive(false);
        started = false;
        wentOver = false;
        returning = false;
    }

    @Override
    public void execute()   {
        if (swerve.getRoll() > 13)  {
            started = true;
        }
        if (swerve.getRoll() < -13 && started){
            wentOver = true;
        }
    }

    @Override
    public boolean isFinished() {
        if (swerve.getRoll() < 1 && wentOver)    {
            swerve.xStance();
            return true;
        }
        return false;
    }
}