package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.CoralSubsystem;

public class MoveRollerTimed extends Command {
    CoralSubsystem coralSubsystem;
    private final double duration;
    double speed;
    Timer timer;

    public MoveRollerTimed(CoralSubsystem coralSubsystem, double duration, double speed) {
        this.coralSubsystem = coralSubsystem;
        this.duration = duration;
        this.speed = speed;
        addRequirements(coralSubsystem);
    }

    @Override
    public void initialize() {
        timer = new Timer();
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        coralSubsystem.moveRoller(speed);
        coralSubsystem.setSafetyEnable(false); // Call the defined method
    }

    @Override
    public void end(boolean interrupted) {
        coralSubsystem.moveRoller(0); // Stop the roller
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(duration);
    }
}
