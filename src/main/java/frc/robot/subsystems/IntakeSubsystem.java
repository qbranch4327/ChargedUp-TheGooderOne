package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    CANSparkMax intakeMotor;
    DoubleSolenoid intake1;
    DoubleSolenoid intake2;

    public IntakeSubsystem()    {
        intakeMotor = new CANSparkMax(1, MotorType.kBrushless);
        intake1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);
        intake2 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 2, 3);
    }

    public void intakeOn()  {
        intakeMotor.set(0.5);
        // intake1.set(DoubleSolenoid.Value.kForward);
        // intake2.set(DoubleSolenoid.Value.kForward);
    }

    public void intakeOff() {
        intakeMotor.stopMotor();
        // intake1.set(DoubleSolenoid.Value.kReverse);
        // intake2.set(DoubleSolenoid.Value.kReverse);
        // intake1.set(DoubleSolenoid.Value.kOff);
        // intake2.set(DoubleSolenoid.Value.kOff);
    }

    public boolean isCone()     {
        return true;
    }

}
