package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.commands.MoveRollerTimed;

public class TimedAuto extends SequentialCommandGroup{

    public TimedAuto(DriveTrainSubsystem driveTrainSubsystem, CoralSubsystem coralSubsystem) {

        addRequirements(driveTrainSubsystem, coralSubsystem);



        addCommands(
            new DriveTimed(driveTrainSubsystem, 2.2).withSpeed( -0.80).withRotation(0),
            new MoveRollerTimed(coralSubsystem, 0.6, .8),
            new DriveTimed(driveTrainSubsystem, 0.5),
            new DriveTimed(driveTrainSubsystem, .6).withSpeed (1).withRotation(0),
            new DriveTimed(driveTrainSubsystem, .5).withSpeed (0).withRotation(0.55),
            new DriveTimed(driveTrainSubsystem, .85).withSpeed(-1).withRotation(0),
            new DriveTimed(driveTrainSubsystem, .5).withSpeed(0).withRotation(-1.2),
            new DriveTimed(driveTrainSubsystem,0.95).withSpeed(0.9),
            new DriveTimed(driveTrainSubsystem, 0.3).withSpeed(0).withRotation(-0.7),
            new DriveTimed(driveTrainSubsystem,0.5).withSpeed(0.7),
            new DriveTimed(driveTrainSubsystem, 1).withSpeed(0).withRotation(0),
            new DriveTimed(driveTrainSubsystem,0.5).withSpeed(-0.3).withRotation(0),
            new DriveTimed(driveTrainSubsystem, 0.3).withSpeed(0).withRotation(0.3),
            new DriveTimed(driveTrainSubsystem, 0.3).withSpeed(-0.1).withRotation(0),
            new DriveTimed(driveTrainSubsystem, 0.3).withSpeed(0).withRotation(-0.2),
            new DriveTimed(driveTrainSubsystem, 1.5).withSpeed(-0.5).withRotation(0),
            new MoveRollerTimed(coralSubsystem, 0.4, .6),
            new DriveTimed(driveTrainSubsystem, 2.0).withSpeed(0.3).withRotation(0)
        
          
           
        );
    }
    
}
