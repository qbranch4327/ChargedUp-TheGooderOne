package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ElevatorCommand extends CommandBase {
    
    XboxController controller;
    ElevatorSubsystem elevatorSubsystem;
    TiltSubsystem tiltSubsystem;
    private final double homeValue = 0.18;

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
            tiltSubsystem.tiltDown(0.41);
        }
        else if (controller.getXButton())    {
            elevatorSubsystem.goUp(-10022);
            tiltSubsystem.tiltDown(0.41);
        }
        else    {
            elevatorSubsystem.goDown(-750);
            tiltSubsystem.tiltUp(homeValue);
        }
    }
}
