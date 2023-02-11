package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class VomitCommand extends CommandBase  {

    IntakeSubsystem intake;
    Timer timer = new Timer();

    public VomitCommand(IntakeSubsystem intake)   {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        intake.vomit();
    }

    @Override
    public boolean isFinished() {
        if (timer.get() > 2)    {
            return true;
        }
        else    {
            return false;
        }
    }
}
