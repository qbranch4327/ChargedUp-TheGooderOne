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
            elevatorSubsystem.goUp(-13800);
            tiltSubsystem.tiltUp(0.79);
        }
        else if (controller.getXButton())    {
            elevatorSubsystem.goUp(-10022);
            tiltSubsystem.tiltUp(0.84);
        }
        else if (controller.getAButton())    {
            elevatorSubsystem.goDown(0.0);
            tiltSubsystem.tiltDown(0.568);
        }
        else    {
            elevatorSubsystem.goDown(0.0);
            tiltSubsystem.tiltDown(0.568);
        }
    }

}
