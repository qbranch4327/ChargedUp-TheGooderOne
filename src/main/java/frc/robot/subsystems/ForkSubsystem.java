package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ForkSubsystem extends SubsystemBase{
    private CANSparkMax fork;

    public ForkSubsystem(){
    }

    public void goUp()  {
        fork.set(0.5);
    }
    
    public void goDown(){
        fork.set(-0.5);
    }

    public void go(double pwr){
        fork.set(pwr);
    }

}
