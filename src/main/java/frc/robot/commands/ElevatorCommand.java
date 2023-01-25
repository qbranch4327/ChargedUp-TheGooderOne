package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ElevatorCommand extends CommandBase {
    
    XboxController controller;
    ElevatorSubsystem elevatorSubsystem;
    TiltSubsystem inclinatorSubsystem;

    public ElevatorCommand(ElevatorSubsystem eSubsystem, TiltSubsystem iSubsystem, XboxController controller)  {
        this.controller = controller;
        this.elevatorSubsystem = eSubsystem;
        this.inclinatorSubsystem = iSubsystem;
        addRequirements(elevatorSubsystem);
        addRequirements(inclinatorSubsystem);
    }

    @Override 
    public void execute()   {
        if (controller.getAButton())    {
            elevatorSubsystem.goUp(Data.n("upperDistance"));
            inclinatorSubsystem.tiltUp(Data.n("upperDegree"));
        }
        if (controller.getBButton())    {
            elevatorSubsystem.goUp(Data.n("middleDistance"));
            inclinatorSubsystem.tiltUp(Data.n("middleDegree"));
        }
        if (controller.getYButton())    {
            elevatorSubsystem.goDown(Data.n("restPosition"));
            inclinatorSubsystem.tiltDown(Data.n("restDegree"));
        }
    }

}
