package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;

public class TimedAuto extends SequentialCommandGroup{

    public TimedAuto(DriveTrainSubsystem driveTrainSubsystem) {

        addRequirements(driveTrainSubsystem);

        addCommands(
            new DriveTimed(driveTrainSubsystem, 2.5)
            // scoring
        );
    }
    
}
