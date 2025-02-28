// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DrivewithPS5Command;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.io.IOException;
import java.nio.file.Path;


import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  private final CoralSubsystem coralSubsystem = new CoralSubsystem();
  
  public static final PS5Controller m_ps5Controller = new PS5Controller(0);
 
  SendableChooser<Command> chooser = new SendableChooser<>();
   
  // Replace with CommandPS4Controller or CommandJoystick if needed
    private final PS5Controller m_driverController =
        new PS5Controller(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    driveTrainSubsystem.setDefaultCommand(new DrivewithPS5Command(driveTrainSubsystem));
    
    coralSubsystem.setDefaultCommand(new DrivewithPS5Command(coralSubsystem));

    chooser.addOption("Hard Path",pathplannerTrajectroyRamsetCommand("C:\\Users\\joshu\\Desktop\\5074V1Code\\src\\main\\deploy\\pathplanner\\paths\\Hard Path.path", true));
    chooser.addOption("Easy Path", pathplannerTrajectroyRamsetCommand("C:\\Users\\joshu\\Desktop\\5074V1Code\\src\\main\\deploy\\pathplanner\\paths\\Easy Path.path", true));
   

    Shuffleboard.getTab("Autonomous").add(chooser);
       
  }
  public Command pathplannerTrajectroyRamsetCommand(String Filname, boolean resetOdometry) {
    @SuppressWarnings("unused")
    Trajectory trajectory;  
    try {  Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(Filname);
      trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
    } catch (IOException e) {
      DriverStation.reportError("Unable to open trajectory" + Filname, e.getStackTrace());
      System.out.println("Unable to read from file " + Filname);
        return new InstantCommand();
      }
          return null;
    }
 

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(driveTrainSubsystem::exampleCondition)
        .onTrue(new DrivewithPS5Command(driveTrainSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    new Trigger(() -> m_driverController.getRawButton(2)).whileTrue(driveTrainSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(driveTrainSubsystem);
  }
}
