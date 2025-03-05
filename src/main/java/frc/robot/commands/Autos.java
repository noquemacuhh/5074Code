// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.AlgaeSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

//import frc.robot.subsystems.DriveTrainSubsystem;
//import edu.wpi.first.wpilibj2.command.Command;


public final class Autos {
  //Example static factory for an autonomous command. 
  public static Command exampleAuto(DriveTrainSubsystem driveTrainSubsystem, CoralSubsystem coralsubsystem, ArmSubsystem armSubsystem, AlgaeSubsystem algaeSubsystem) {
  return Commands.sequence(driveTrainSubsystem.exampleMethodCommand(), new DrivewithPS5Command(driveTrainSubsystem, coralsubsystem, armSubsystem, algaeSubsystem));
  }
  
  
  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
