package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpinnerSubsystem extends SubsystemBase {

    PWMSparkMax spinnerMotor;

    public SpinnerSubsystem()   {
        spinnerMotor = new PWMSparkMax(3);
    }

    public void spin(boolean dir)  {
        if (dir){
            spinnerMotor.set(0.2);
        }
        else{
            spinnerMotor.set(-0.2);
        }
    }

    public void stop(){
        spinnerMotor.stopMotor();
    }
}
