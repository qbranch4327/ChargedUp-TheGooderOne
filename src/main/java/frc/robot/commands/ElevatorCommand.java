package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ElevatorCommand extends CommandBase {
    
    XboxController controller;
    ElevatorSubsystem elevatorSubsystem;
    TiltSubsystem tiltSubsystem;

    public ElevatorCommand(ElevatorSubsystem eSubsystem, TiltSubsystem tSubsystem, XboxController controller)  {
        this.controller = controller;
        this.elevatorSubsystem = eSubsystem;
        this.tiltSubsystem = tSubsystem;
        addRequirements(elevatorSubsystem);
        addRequirements(tiltSubsystem);
    }

    @Override
    public void initialize()   {
        elevatorSubsystem.resetEncoders();
        //tiltSubsystem.resetEncoders();
    }

    @Override 
    public void execute()   {
        if (controller.getYButton())    {
            elevatorSubsystem.goUp(-8656);
            //tiltSubsystem.tiltUp(Data.n("upperDegree"));
        }
        else if (controller.getXButton())    {
            elevatorSubsystem.goUp(-4699);
            //elevatorSubsystem.goUp(Data.n("middleDistanceData.n("middleDegree"));
        }
        else if (controller.getAButton())    {
            elevatorSubsystem.goDown(0.0);
            //tiltSubsystem.tiltDown(Data.n("restDegree"));
        }
        else    {
            elevatorSubsystem.stop();
        }
    }

}
