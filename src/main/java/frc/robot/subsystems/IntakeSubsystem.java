package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    PWMSparkMax intakeMotor;
    DoubleSolenoid intake1;
    DoubleSolenoid intake2;
    DoubleSolenoid grip1;

    public IntakeSubsystem()    {
        intakeMotor = new PWMSparkMax(0);
        grip1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 0);
        // intake1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 4, 5);
        // intake2 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 6, 7);
    }

    public void intakeOn()  {
        intakeMotor.set(-1);
        // intake1.set(DoubleSolenoid.Value.kForward);
        // intake2.set(DoubleSolenoid.Value.kForward);
    }

    //public void intakeOn(boolean reverse)  {
        // if (!reverse)    {
            // intakeMotor.set(0.5);
        //}
        // else {
            // intakeMotor.set(-.5);
        //}
        // intake1.set(DoubleSolenoid.Value.kForward);
        // intake2.set(DoubleSolenoid.Value.kForward);
    //}

    // public void intakeReverse(){
    //     intakeMotor.set(-1);
    // }

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

    public void grab()  {
        grip1.set(DoubleSolenoid.Value.kForward);
    }

    public void release()   {
        grip1.set(DoubleSolenoid.Value.kReverse);
    }

    public void vomit() {
        intakeMotor.set(1);
    }

    public boolean status(){
        if (grip1.get() == DoubleSolenoid.Value.kForward){
            return true;
        }
        else{
            return false;
        }
    }

}
