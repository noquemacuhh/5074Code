// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralSubsystem extends SubsystemBase {
  /** Creates a new CoralSubsystem. */
  private final SparkMax coralrelease;

  @SuppressWarnings("deprecation")
  public CoralSubsystem() {
      coralrelease = new SparkMax(Constants.CoralConstants.CoralMotorID, MotorType.kBrushed);
      coralrelease.setInverted(false);


      
     
    
  }
  public void moveRoller(double speed) {
    coralrelease.set(0.8 * speed);

  }
  public Command moveRoller(int coralrelase, double speed) {
    return new Command() {
        @Override
        public void initialize() {
            moveRoller(speed);
        }
        @Override
        public boolean isFinished() {
            return false;
        }
    };
  }
  public void setSafetyEnable(boolean enable) {
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
