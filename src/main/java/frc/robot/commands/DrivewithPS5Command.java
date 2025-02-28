// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DrivewithPS5Command extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSubsystem driveTrainSubsystem;
  @SuppressWarnings("unused")
  private CoralSubsystem coralSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DrivewithPS5Command(DriveTrainSubsystem driveTrainSubsystem) {
    this.driveTrainSubsystem = driveTrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrainSubsystem);
  }

  public DrivewithPS5Command(CoralSubsystem coralrelease) {
    this.driveTrainSubsystem = null; // or initialize it properly if needed
    this.coralSubsystem = coralrelease;
    addRequirements(coralSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("STARTING PS5COMMAND DRIVE");
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double fowardspeed = RobotContainer.m_ps5Controller.getLeftY();
    double turnspeed = RobotContainer.m_ps5Controller.getRightX();
    driveTrainSubsystem.arcadeDrive(fowardspeed, -turnspeed);
    
    double speed = RobotContainer.m_ps5Controller.getR2Axis();
    coralSubsystem.moveRoller(speed);
  }
  public void moveRoller(double speed) {
    coralSubsystem.moveRoller(speed);
  }
  public void arcadeDrive(double fwd, double rot) {
    driveTrainSubsystem.arcadeDrive(fwd, rot);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
