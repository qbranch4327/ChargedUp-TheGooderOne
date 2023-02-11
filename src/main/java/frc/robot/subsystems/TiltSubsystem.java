package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType; 
import java.lang.Math;

public class TiltSubsystem extends SubsystemBase  {
    
    PWMSparkMax tiltMotor;
    DutyCycleEncoder tiltEncoder;
    // private final int CyclesPerRevolution = 2048;
    // private final double circumference = 1.76 * Math.PI;
    private final double holdingV = -0.3;
    private final double tiltOffset = -0.2;

    public TiltSubsystem()    {
        tiltMotor = new PWMSparkMax(1);
        tiltEncoder = new DutyCycleEncoder(2);
        // tiltEncoder.setDistancePerRotation(circumference/CyclesPerRevolution);
        // tiltEncoder.setDutyCycleRange(Data.n("restDegree"), Data.n("upperDegree"));
    }

    public void tiltDown(double degrees)    {
        if (tiltEncoder.getAbsolutePosition() >= degrees + 0.03)   {
            tiltMotor.set(0.15);
        }
        else if(tiltEncoder.getAbsolutePosition() <= degrees - 0.03){
            tiltMotor.set(-0.25);
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
        if (tiltEncoder.getAbsolutePosition() >= degrees + 0.03 || tiltEncoder.getAbsolutePosition() <= degrees - 0.03)   {
            tiltMotor.set(-0.25);
        }
        else{
            tiltMotor.stopMotor();
        }
    }

   // public void resetEncoders() {
   //     tiltEncoder.reset();
   // }

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
