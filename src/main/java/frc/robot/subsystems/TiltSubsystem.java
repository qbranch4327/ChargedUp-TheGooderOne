package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TiltSubsystem extends SubsystemBase  {
    
    PWMSparkMax tiltMotor;
    DutyCycleEncoder tiltEncoder;
    private final double holdingV = -0.3;
    public TiltSubsystem()    {
        tiltMotor = new PWMSparkMax(1);
        tiltEncoder = new DutyCycleEncoder(2);
    }

    public void tiltDown(double degrees)    {
        if (tiltEncoder.getAbsolutePosition() >= degrees + 0.01)   {
            tiltMotor.set(0.15);
        }
        else if(tiltEncoder.getAbsolutePosition() <= degrees - 0.01){
            tiltMotor.set(0.15);
        }
        else{
            tiltMotor.set(holdingV);
        }
    }

    public void tiltDown(){
        tiltMotor.set(-.1);
    }

    public void tiltUp()  {
        tiltMotor.set(.1);
    }

    public void tiltUp(double degrees)    {
        if (tiltEncoder.getAbsolutePosition() >= degrees + 0.01 || tiltEncoder.getAbsolutePosition() <= degrees - 0.01)   {
            tiltMotor.set(-0.25);
        }
        else{
            tiltMotor.stopMotor();
        }
    }

    public boolean encoderCheck(double distance){
        if (tiltEncoder.getAbsolutePosition() == distance)  {
            return true;
        }
        return false;
    }

    @Override
    public void periodic()  {
        SmartDashboard.putNumber("Tilt Encoder", (tiltEncoder.getAbsolutePosition()));
    }

}
