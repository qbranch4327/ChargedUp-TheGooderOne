package frc.robot.commands;

import frc.robot.subsystems.ForkSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

public class ForkCommand extends CommandBase{
    private ForkSubsystem fork;
    private Joystick controller;


    public ForkCommand(ForkSubsystem fork, Joystick controller) {
        this.fork = fork;
        this.controller = controller;
        addRequirements(fork);
    }

    @Override
    public void execute(){
        if(controller.getRawButton(1)){
            fork.goUp();
        }
        else if(controller.getRawButton(4)){
            fork.goDown();
        }
    }
}
