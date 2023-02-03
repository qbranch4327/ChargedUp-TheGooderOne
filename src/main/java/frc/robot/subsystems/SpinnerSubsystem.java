package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class SpinnerSubsystem extends SubsystemBase {

    CANSparkMax spinnerMotor;
    DigitalInput spinnerStop;

    public SpinnerSubsystem()   {
        spinnerMotor = new CANSparkMax(2, MotorType.kBrushless);
        spinnerStop = new DigitalInput(9);
    }

    public void spin()  {
        spinnerMotor.set(0.2);
        if (spinnerStop.get())    {
            spinnerMotor.stopMotor();
        }
    }
}
