package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

public class TiltSubsystem extends SubsystemBase  {
    
    PWMSparkMax tiltMotor;
    DutyCycleEncoder tiltEncoder;

    public TiltSubsystem()    {
        tiltMotor = new PWMSparkMax(1);
        tiltEncoder = new DutyCycleEncoder(2);
    }

    public void tiltUp(double degrees)    {
        tiltMotor.set(0.15);
        if (tiltEncoder.getDistance() == degrees)   {
            tiltMotor.stopMotor();
        }
    }

    public void tiltDown(double degrees)    {
        tiltMotor.set(-0.15);
        if (tiltEncoder.getDistance() == degrees)   {
            tiltMotor.stopMotor();
        }
    }

   // public void resetEncoders() {
   //     tiltEncoder.reset();
   // }

    public boolean encoderCheck(double distance){
        if (tiltEncoder.getDistance() == distance)  {
            return true;
        }
        return false;
    }

}
