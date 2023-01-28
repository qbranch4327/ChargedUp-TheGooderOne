package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class IntakeCommand extends CommandBase {
    
    GripSubsystem gripSubsystem;
    IntakeSubsystem intakeSubsystem;
    SpinnerSubsystem spinnerSubsystem;
    XboxController controller;

    public IntakeCommand(GripSubsystem gripSubsystem, IntakeSubsystem intakeSubsystem, SpinnerSubsystem spinnerSubsystem, XboxController controller)  {
        this.gripSubsystem = gripSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.spinnerSubsystem = spinnerSubsystem;
        this.controller = controller;
        addRequirements(gripSubsystem);
        addRequirements(intakeSubsystem);
        addRequirements(spinnerSubsystem);
    }

    @Override
    public void execute()   {
        if (controller.getLeftY() > .2)   {
            intakeSubsystem.intakeOn();
        }
        else    {
            intakeSubsystem.intakeOff();
            if (intakeSubsystem.isCone())   {
                spinnerSubsystem.spin();
            }
        }
        if (controller.getLeftTriggerAxis() > .2)    {
            gripSubsystem.grab();
        }
        else if (controller.getRightTriggerAxis() > .2)   {
            gripSubsystem.release();
        }
        else    {
            gripSubsystem.rest();
        }
    }

}
