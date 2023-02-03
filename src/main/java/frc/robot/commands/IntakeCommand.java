package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class IntakeCommand extends CommandBase {
    
    GripSubsystem gripSubsystem;
    IntakeSubsystem intakeSubsystem;
    SpinnerSubsystem spinnerSubsystem;
    Joystick controller1;
    XboxController controller2;

    public IntakeCommand(GripSubsystem gripSubsystem, IntakeSubsystem intakeSubsystem, SpinnerSubsystem spinnerSubsystem, XboxController controller2, Joystick controller1)  {
        this.gripSubsystem = gripSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.spinnerSubsystem = spinnerSubsystem;
        this.controller1 = controller1;
        this.controller2 = controller2;
        addRequirements(gripSubsystem);
        addRequirements(intakeSubsystem);
        addRequirements(spinnerSubsystem);
    }

    @Override
    public void execute()   {
        if (controller1.getRawAxis(12) > .2)   {
            intakeSubsystem.intakeOn();
        }
        else    {
            intakeSubsystem.intakeOff();
            if (intakeSubsystem.isCone())   {
                spinnerSubsystem.spin();
            }
        }
        if (controller2.getLeftTriggerAxis() > .2)    {
            gripSubsystem.grab();
        }
        else if (controller2.getRightTriggerAxis() > .2)   {
            gripSubsystem.release();
        }
        else    {
            gripSubsystem.rest();
        }
    }

}
