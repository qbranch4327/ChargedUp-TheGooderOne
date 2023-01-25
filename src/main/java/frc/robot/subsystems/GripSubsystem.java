package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class GripSubsystem extends SubsystemBase  {

    DoubleSolenoid grip1;
    DoubleSolenoid grip2;
    
    public GripSubsystem()    {
        grip1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 4, 5);
        grip2 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 6, 7);
    }

    public void grab()  {
        grip1.set(DoubleSolenoid.Value.kForward);
        grip2.set(DoubleSolenoid.Value.kForward);
    }

    public void release()   {
        grip1.set(DoubleSolenoid.Value.kReverse);
        grip2.set(DoubleSolenoid.Value.kReverse);
    }

    public void rest()  {
        grip1.set(DoubleSolenoid.Value.kOff);
        grip2.set(DoubleSolenoid.Value.kOff);
    }
}
