package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

public class TiltSubsystem extends SubsystemBase  {
    
    PWMSparkMax tiltMotor;
    DutyCycleEncoder tiltEncoder;
    // private final int CyclesPerRevolution = 2048;
    // private final double circumference = 1.76 * Math.PI;
    private final double holdingV = -0.3;

    public TiltSubsystem()    {
        tiltMotor = new PWMSparkMax(1);
        tiltEncoder = new DutyCycleEncoder(2);
        // tiltEncoder.setDistancePerRotation(circumference/CyclesPerRevolution);
        // tiltEncoder.setDutyCycleRange(Data.n("restDegree"), Data.n("upperDegree"));
    }

    public void tiltUp(double degrees)    {
        tiltMotor.set(0.15);
        if (tiltEncoder.getAbsolutePosition() >= degrees)   {
            tiltMotor.set(holdingV);
        }
    }

    public void tiltUp(){
        tiltMotor.set(-.1);
    }

    public void tiltDown()  {
        tiltMotor.set(.1);
    }

    public void tiltDown(double degrees)    {
        tiltMotor.set(-0.25);
        if (tiltEncoder.getAbsolutePosition() <= degrees)   {
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
