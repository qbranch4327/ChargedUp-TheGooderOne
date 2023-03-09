package frc.robot.commands;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class DockCommand {
    
    Swerve swerve;

    public DockCommand(Swerve swerve)    {
        this.swerve = swerve;
    }

    public void balance()   {
        boolean start = false;
        if (swerve.getPitch() > 13)    {
            swerve.slowDown();
            start = true;
        }
        else if (swerve.getPitch() < 12 && start)    {
            swerve.xStance();
        }
    }

}
