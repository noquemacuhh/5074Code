package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;

import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    private final SparkMax armMotor = new SparkMax(Constants.ArmConstants.ArmMotorID, MotorType.kBrushed);
    

    public ArmSubsystem() {
        //armMotor.setInverted(true);
        //armEncoder.setPosition(0);
    }

    public void moveArm(double speed) {
        armMotor.set(0.1 * speed);
    }

    public Command runArm(ArmSubsystem arm, double speed) {
        return new Command() {
            @Override
            public void initialize() {
                moveArm(speed);
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
    }

    public void stopArm() {
        //armMotor.stopMotor();
    }
    
}
