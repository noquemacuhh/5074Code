// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.AlgaeSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.RobotContainer;

public class DrivewithPS5Command extends Command {
  private final DriveTrainSubsystem driveTrainSubsystem;
  private final CoralSubsystem coralSubsystem;
  private final ArmSubsystem armSubsystem;
  private final AlgaeSubsystem algaeSubsystem;

  public DrivewithPS5Command(DriveTrainSubsystem driveTrainSubsystem, CoralSubsystem coralSubsystem, ArmSubsystem armSubsystem, AlgaeSubsystem algaeSubsystem) {
    this.driveTrainSubsystem = driveTrainSubsystem;
    this.coralSubsystem = coralSubsystem;
    this.armSubsystem = armSubsystem;
    this.algaeSubsystem = algaeSubsystem;
    addRequirements(driveTrainSubsystem, coralSubsystem, armSubsystem, algaeSubsystem);
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

    double currentR2AxisValue = RobotContainer.m_ps5Controller.getR2Axis();
    boolean isR2ButtonPressed = currentR2AxisValue > 0.5; // Adjust the threshold as needed

    boolean currentR1ButtonState = RobotContainer.m_ps5Controller.getR1Button();
   
    double currentL2AxisValue = RobotContainer.m_ps5Controller.getL2Axis();
    boolean isL2ButtonPressed = currentL2AxisValue > 0.5; // Adjust the threshold as needed

    boolean currentL1ButtonState = RobotContainer.m_ps5Controller.getL1Button();

    boolean currentCrossButtonState = RobotContainer.m_ps5Controller.getCrossButton();
    boolean isCrossButtonPressed = currentCrossButtonState; // Use the boolean value directly

    boolean currentSquareButtonState = RobotContainer.m_ps5Controller.getSquareButton();
    boolean isSquareButtonPressed = currentSquareButtonState; // Use the boolean value directly

    // Control the arm motor based on L2 axis and L1 button
    if (isL2ButtonPressed) {
      armSubsystem.moveArm(5.0); // Move forward
    } else if (currentL1ButtonState) {
      armSubsystem.moveArm(-5.0); // Move backward
    } else {
      armSubsystem.moveArm(0.0); // Stop the motor
    }
    // Control the coral release motor based on R2 axis and R1 button
    if (isR2ButtonPressed) {
      coralSubsystem.moveRoller(0.8); // Move forward
    } else if (currentR1ButtonState) {
      coralSubsystem.moveRoller(-0.8); // Move backward
    } else {
      coralSubsystem.moveRoller(0.0); // Stop the motor
    }
    // Control the algae motor based on Cross and Square buttons
    if (isCrossButtonPressed) {
      algaeSubsystem.movealgae(0.8); // Move forward
    } else if (isSquareButtonPressed) {
      algaeSubsystem.movealgae(-0.8); // Move backward
    } else {
      algaeSubsystem.movealgae(0.0); // Stop the motor
    }
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