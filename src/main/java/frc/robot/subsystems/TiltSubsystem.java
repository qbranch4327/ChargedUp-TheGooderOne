package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.*;

public class TiltSubsystem extends SubsystemBase  {
    
    private CANSparkMax tiltMotor;
    private DutyCycleEncoder tiltEncoder;
    private PIDController armController;
    private final double holdingV = -0.085;

    public TiltSubsystem()    {
        tiltMotor = new CANSparkMax(14, MotorType.kBrushless);
        tiltEncoder = new DutyCycleEncoder(2);
        armController = new PIDController(1, 0, 1);
        armController.setTolerance(0.02, 0.02);
    }

    public void tilt(double pos)    {

        if (!(armController.atSetpoint())) {
            tiltMotor.set(armController.calculate(tiltEncoder.getAbsolutePosition(), pos));
            System.out.println("MOVING");
        }
        else {
            tiltMotor.stopMotor();
            System.out.println("OK");
        }
        
    }

    public void tiltDown(){
        tiltMotor.set(-.1);
    }

    public void tiltUp()  {
        tiltMotor.set(.08);
    }

    public void tiltUp(double pos)    {
        if (tiltEncoder.getAbsolutePosition() >= pos + 0.01 || tiltEncoder.getAbsolutePosition() <= pos - 0.01)   {
            tiltMotor.set(-0.15);
        }
        else{
            tiltMotor.stopMotor();
        }
    }

    public void emergencyTiltUp(double pos){
        if (tiltEncoder.getAbsolutePosition() >= pos + 0.01 || tiltEncoder.getAbsolutePosition() <= pos - 0.01)   {
            tiltMotor.set(-0.45);
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
