package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends SubsystemBase{

    PWMSparkMax elevator;
    Encoder elevatorEncoder;
    //elevator1 is the tilt
    //elevator2 is the carriage
    public ElevatorSubsystem()  {
        elevator = new PWMSparkMax(2);
        elevatorEncoder = new Encoder(0, 1);
        elevator.setInverted(false);
    }

    public void goUp(double distance)  {
        if (elevatorEncoder.getDistance() >= distance + 200)   {
            elevator.set(0.50);
        }
        else if(elevatorEncoder.getDistance() <= distance - 200){
            elevator.set(-0.30);
        }
        else{
            elevator.stopMotor();
        }
    }
    
    public void goUp()  {
        elevator.set(.5);
    }
    
    public void goDown(){
        elevator.set(-.3);
    }

    public void goDown(double distance)  {
        elevator.set(-0.30);
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

    public double encoderValue(){
        return elevatorEncoder.getDistance();
    }

}
