package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;

public class TiltSubsystem extends SubsystemBase  {
    
    CANSparkMax tiltMotor;
    DutyCycleEncoder tiltEncoder;
    private final PIDController armCtrl;
    private final double holdingV = -0.085;

    public TiltSubsystem()    {
        tiltMotor = new CANSparkMax(14, MotorType.kBrushless); //TODO: Change to CAN 14 for real robot, 17 for test chassis
        tiltEncoder = new DutyCycleEncoder(2);
        
        armCtrl = new PIDController(2,0, 0.000);
        armCtrl.setTolerance(0.02);

    }

    public void tilt(double pos)    {

        if (armCtrl.atSetpoint()) {
            tiltMotor.set(armCtrl.calculate(tiltEncoder.getAbsolutePosition(), pos));
            System.out.println("MOVING TO " + pos);
            System.out.println(armCtrl.atSetpoint());

        }
        else {
            tiltMotor.stopMotor();
            System.out.println("OK");
            System.out.println(armCtrl.atSetpoint());
        }
        
    }

    public void emergencyTiltUp(double degrees){
        if (tiltEncoder.getAbsolutePosition() >= degrees + 0.01 || tiltEncoder.getAbsolutePosition() <= degrees - 0.01)   {
            tiltMotor.set(-0.45);
        }
        else{
            tiltMotor.stopMotor();
        }
    }

    public void resetPID(){
        armCtrl.reset();
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
