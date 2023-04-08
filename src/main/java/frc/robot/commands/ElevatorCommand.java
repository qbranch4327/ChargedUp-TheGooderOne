package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ElevatorCommand extends CommandBase {
    
    XboxController controller;
    ElevatorSubsystem elevatorSubsystem;
    TiltSubsystem tiltSubsystem;
    private final double homeValue = 0.270;
    private final double scoreValue = 0.190;

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
        tiltSubsystem.resetPID();
    }

    @Override 
    public void execute()   {
        if (controller.getYButton())    {
            elevatorSubsystem.goUp(-13800);
            tiltSubsystem.tilt(scoreValue);
            System.out.println("HIGH");

        }
        else if (controller.getXButton())    {
            elevatorSubsystem.goUp(-9622);
            tiltSubsystem.tilt(scoreValue);
            System.out.println("MID");

        }
        // else if (controller.getAButton())  {
        //     // elevatorSubsystem.goUp(-7000);
        //     // tiltSubsystem.tiltDown(scoreValue);
        // }
        else    {
            elevatorSubsystem.goDown(-150);
            tiltSubsystem.tilt(homeValue);
            System.out.println("HOME");
        }
    }
}
