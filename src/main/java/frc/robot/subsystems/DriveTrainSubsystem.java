// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.revrobotics.RelativeEncoder;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  SparkMax LeftFront = new SparkMax(Constants.DriveTrainConstants.LeftFrontID, MotorType.kBrushless);
  SparkMax LeftBack = new SparkMax(Constants.DriveTrainConstants.LeftBackID, MotorType.kBrushless);
  SparkMax RightFront = new SparkMax(Constants.DriveTrainConstants.RightFrontID, MotorType.kBrushless);
  SparkMax RightBack = new SparkMax(Constants.DriveTrainConstants.RightBackID, MotorType.kBrushless);

  //These are going to be in as a comment incase we use encoders in the future
  /* 
  RelativeEncoder leftEncoder = LeftFront.getEncoder();
  RelativeEncoder rightEncoder = RightFront.getEncoder();
  */
  
  @SuppressWarnings("removal")
  MotorControllerGroup LeftMotors = new MotorControllerGroup(LeftFront, LeftBack);
  @SuppressWarnings("removal")
  MotorControllerGroup RightMotors = new MotorControllerGroup(RightFront, RightBack);
    


  DifferentialDrive drive = new DifferentialDrive(LeftMotors, RightMotors);

  
  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  @SuppressWarnings("deprecation")
  public DriveTrainSubsystem() {
    //set up the motors
    LeftFront.setInverted(true);
    LeftBack.setInverted(true);
    RightFront.setInverted(false);
    RightBack.setInverted(false);

    //set up the encoders
    /* 
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
    */

  
  
  }
  
  
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
