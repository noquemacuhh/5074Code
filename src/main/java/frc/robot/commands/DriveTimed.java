package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTimed extends Command {

    DriveTrainSubsystem driveTrainSubsystem;
    double seconds;
    double rotation;
    private final double duration;
    double speed;
    Timer timer;
    

    public DriveTimed(DriveTrainSubsystem driveTrainSubsystem, double seconds) {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.seconds = seconds;
        this.duration = seconds;
       

        addRequirements(driveTrainSubsystem);

        timer = new Timer();
    }
    public DriveTimed withSpeed(double speed) {
        this.speed = speed;
        return this;
    }
    public DriveTimed withRotation(double rotation) {
        this.rotation = rotation;
        return this;
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer = new Timer();
        timer.reset();
        timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        driveTrainSubsystem.arcadeDrive(speed, rotation);
        
        

    }
    


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Add code here to stop the robot's drive system
        driveTrainSubsystem.arcadeDrive(0, 0);
        timer.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return timer.hasElapsed(duration); // Change this condition based on your requirements
    }
    
}
