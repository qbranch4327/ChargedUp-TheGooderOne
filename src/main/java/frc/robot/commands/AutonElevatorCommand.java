package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
 
public class AutonElevatorCommand extends CommandBase{
    ElevatorSubsystem elevatorSubsystem;
    TiltSubsystem tiltSubsystem;
    GripSubsystem gripSubsystem;
    Timer timer;
    double startTime = 0;
    double endTime = 0;
    
    public AutonElevatorCommand(ElevatorSubsystem elevatorSubsystem, TiltSubsystem tiltSubsystem, GripSubsystem gripSubsystem, Timer timer) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.tiltSubsystem = tiltSubsystem;
        this.gripSubsystem = gripSubsystem;
        this.timer = timer;
        addRequirements(elevatorSubsystem);
        addRequirements(tiltSubsystem);
        addRequirements(gripSubsystem);
    }

    @Override
    public void initialize() {
        elevatorSubsystem.resetEncoders();
    }

    @Override
    public void execute() {
        if (timer.get() == startTime)   {
            elevatorSubsystem.goUp(Data.n("upperDistance"));
            tiltSubsystem.tiltUp(Data.n("upperDegree"));
        }
    }

    @Override
    public boolean isFinished() {
        if (elevatorSubsystem.encoderCheck(Data.n("upperDistance")) && tiltSubsystem.encoderCheck(Data.n("upperDegree")))   {
            gripSubsystem.release();
            return true;
        }
        return false;
    }

}
