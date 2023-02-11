package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class IntakeCommand extends CommandBase {
    
    IntakeSubsystem intakeSubsystem;
    //SpinnerSubsystem spinnerSubsystem;
    Joystick controller1;
    XboxController controller2;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, XboxController controller2, Joystick controller1)  {
        this.intakeSubsystem = intakeSubsystem;
        //this.spinnerSubsystem = spinnerSubsystem;
        this.controller1 = controller1;
        this.controller2 = controller2;
        addRequirements(intakeSubsystem);
        //addRequirements(spinnerSubsystem);
    }

    @Override
    public void execute()   {
        if (controller2.getRightBumper())   {
            intakeSubsystem.intakeOn();
        }
        // else if (controller2.getLeftY() < -.2){
        //     intakeSubsystem.intakeReverse();
        // }
        else    {
           intakeSubsystem.intakeOff();
            // if (intakeSubsystem.isCone())   {
            //     spinnerSubsystem.spin();
            // }
        }
        // if (controller2.getBButton())   {
        //     spinnerSubsystem.spin();
        // }
        // else {
        //     spinnerSubsystem.stop();
        // }
        //spinnerSubsystem.spin();
        

        if (controller2.getLeftBumper())    {
            if (intakeSubsystem.status()){
                intakeSubsystem.release();
            }
            else    {
                intakeSubsystem.grab();
            }
        }
    }

}
