package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class SpinnerSubsystem extends SubsystemBase {

    PWMSparkMax spinnerMotor;
    DigitalInput spinnerStop;

    public SpinnerSubsystem()   {
        spinnerMotor = new PWMSparkMax(3);
        //spinnerStop = new DigitalInput(3);
    }

    public void spin(boolean dir)  {
        if (dir){
            spinnerMotor.set(0.2);
        }
<<<<<<< HEAD
        else {
=======
        else{
>>>>>>> 3f49c0e4ef27028499e2431d57970a523da31999
            spinnerMotor.set(-0.2);
        }
    }

    public void stop(){
        spinnerMotor.stopMotor();
    }
}
