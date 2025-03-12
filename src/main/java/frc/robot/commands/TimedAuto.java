package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class TimedAuto extends SequentialCommandGroup{

    public TimedAuto(DriveTrainSubsystem driveTrainSubsystem, CoralSubsystem coralSubsystem) {

        addRequirements(driveTrainSubsystem, coralSubsystem);

        addCommands(

            //Modify if need -Josh
            new InstantCommand(() -> System.out.println("Forward")),
            new DriveTimed(driveTrainSubsystem, 2.0).withSpeed( -0.5).withRotation(0),

            new InstantCommand(() -> System.out.println("Turn")),
            new DriveTimed(driveTrainSubsystem, 2.0) .withSpeed(0).withRotation(1.8), 

            new InstantCommand(() -> System.out.println("Forward")),
            new DriveTimed(driveTrainSubsystem, .5).withSpeed(-0.5).withRotation(0),

            new InstantCommand(() -> System.out.println("Stop")),
            new DriveTimed(driveTrainSubsystem, 2).withSpeed(0),

            new InstantCommand(() -> System.out.println("Roller")),
            new MoveRollerTimed(coralSubsystem, 0.5, 0.0),

            new InstantCommand(() -> System.out.println("RELEASE")),
            new MoveRollerTimed(coralSubsystem, 0.5, 0.0), 

            new InstantCommand(() ->System.out.println("Backwards")),
            new DriveTimed(driveTrainSubsystem, 0.5).withSpeed(0.5).withRotation(0),

            new InstantCommand(() -> System.out.println("Turn")), 
            new DriveTimed(driveTrainSubsystem, 2.0) .withSpeed(0).withRotation(-1.8),
            
            new InstantCommand(() ->System.out.println("Foward")),
            new DriveTimed(driveTrainSubsystem, 1.0).withSpeed( -0.5).withRotation(0)
           
        );
    }
    
}
