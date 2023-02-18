package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

public class AutonIntakeCommand extends CommandBase{
    IntakeSubsystem intakeSubsystem;
    Timer timer;
    double startTime = 0;
    double endTime = 0;
    boolean position = true;
    
    public AutonIntakeCommand(IntakeSubsystem intakeSubsystem, Timer timer) {
        this.intakeSubsystem = intakeSubsystem;
        this.timer = timer;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        
        if (timer.get() == startTime)   {
            intakeSubsystem.intakeOn(true);
        }
        if (position)   {
            intakeSubsystem.grab();
        }
    }

    @Override
    public boolean isFinished() {
        if (timer.get() == endTime) {
            intakeSubsystem.intakeOff();
            return true;
        }
        return false;
    }

}
