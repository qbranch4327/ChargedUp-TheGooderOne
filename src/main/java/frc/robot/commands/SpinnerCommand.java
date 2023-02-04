package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinnerSubsystem;

public class SpinnerCommand extends CommandBase {
    SpinnerSubsystem spinnerSubsystem;
    XboxController controller2;

    public SpinnerCommand (SpinnerSubsystem spinnerSubsystem, XboxController c2){
        this.spinnerSubsystem = spinnerSubsystem;
        this.controller2 = c2;
        addRequirements(spinnerSubsystem);
    }

    @Override
    public void execute(){
        if (controller2.getBButton()){
            spinnerSubsystem.spin();
        }
        else {
            spinnerSubsystem.stop();
        }
    }
}
