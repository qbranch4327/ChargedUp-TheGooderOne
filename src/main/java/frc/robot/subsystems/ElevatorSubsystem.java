package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ElevatorSubsystem extends SubsystemBase{

    CANSparkMax elevator1;
    CANSparkMax elevator2;
    Encoder elevatorEncoder;

    public ElevatorSubsystem()  {
        elevator1 = new CANSparkMax(6, MotorType.kBrushless);
        elevator2 = new CANSparkMax(7, MotorType.kBrushless);
        elevator1.setInverted(false);
        elevator2.setInverted(true);
        elevatorEncoder = new Encoder(0, 1);
    }

    public void goUp(double distance)  {
        elevator1.set(0.5);
        elevator2.set(0.5);
        if (elevatorEncoder.getDistance() == distance)  {
            elevator1.stopMotor();
            elevator2.stopMotor();
        }
    }

    public void goDown(double distance)  {
        elevator1.set(-0.5);
        elevator2.set(-0.5);
        if (elevatorEncoder.getDistance() == distance)  {
            elevator1.stopMotor();
            elevator2.stopMotor();
        }
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
