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
    
    public AutonIntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        intakeSubsystem.intakeOn(true);
    }

    @Override
    public boolean isFinished() {
        if (timer.get() > 1) {
            intakeSubsystem.intakeOff();
            intakeSubsystem.grab();
            return true;
        }
        return false;
    }

}
