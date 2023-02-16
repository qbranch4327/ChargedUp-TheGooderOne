package frc.robot.subsystems;

import org.w3c.dom.css.ElementCSSInlineStyle;

//import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends SubsystemBase{

    PWMSparkMax elevator;
    Encoder elevatorEncoder;
    //private final int CyclesPerRevolution = 2048;
    //private final double circumference = 1.76 * Math.PI;

    //elevator1 is the tilt
    //elevator2 is the carriage
    public ElevatorSubsystem()  {
        elevator = new PWMSparkMax(2);
        elevatorEncoder = new Encoder(0, 1);
        elevator.setInverted(false);
       // elevatorEncoder.setDistancePerRotation(circumference/CyclesPerRevolution);
       // elevatorEncoder.setDutyCycleRange(Data.n("restPosition"), Data.n("upperDistance"));
    }

    public void goUp(double distance)  {
        if (elevatorEncoder.getDistance() >= distance + 200)   {
            elevator.set(0.35);
        }
        else if(elevatorEncoder.getDistance() <= distance - 200){
            elevator.set(-0.15);
        }
        else{
            elevator.stopMotor();
        }
    }
    public void goUp()  {
        elevator.set(.2);
    }
    
    public void goDown(){
        elevator.set(-.1);
    }

    public void goDown(double distance)  {
        elevator.set(-0.1);
        if (elevatorEncoder.getDistance() >= distance)  {
           elevator.stopMotor();
        }
    }

    public void stop()  {
        elevator.stopMotor();
    }

    public void resetEncoders() {
        elevatorEncoder.reset();
    }

    @Override
    public void periodic()  {
        SmartDashboard.putNumber("Elevator Encoder", (elevatorEncoder.getDistance()));
    }

    public boolean encoderCheck(double distance){
        if (elevatorEncoder.getDistance() == distance)  {
            return true;
        }
        return false;
    }

}
