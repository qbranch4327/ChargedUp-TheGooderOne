package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import java.lang.Math;

public class ElevatorSubsystem extends SubsystemBase{

    PWMSparkMax elevator;
    Encoder elevatorEncoder;
    private final int CyclesPerRevolution = 2048;
    private final double circumference = 1.76 * Math.PI;

    //elevator1 is the tilt
    //elevator2 is the carriage
    public ElevatorSubsystem()  {
        elevator = new PWMSparkMax(2);
        elevatorEncoder = new Encoder(2, 3);
        elevator.setInverted(false);
       // elevatorEncoder.setDistancePerRotation(circumference/CyclesPerRevolution);
       // elevatorEncoder.setDutyCycleRange(Data.n("restPosition"), Data.n("upperDistance"));
    }

    public void goUp(double distance)  {
        elevator.set(0.40);
        //if (elevatorEncoder.getDistance() == distance)  {
        //    elevator.stopMotor();
        //}
    }

    public void goDown(double distance)  {
        elevator.set(-0.1);
        //if (elevatorEncoder.getDistance() == distance)  {
        //    elevator.stopMotor();
        //}
    }

    public void resetEncoders() {
        elevatorEncoder.reset();
    }

    public boolean encoderCheck(double distance){
        if (elevatorEncoder.getDistance() == distance)  {
            return true;
        }
        return false;
    }

}
