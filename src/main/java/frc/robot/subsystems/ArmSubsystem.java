package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import frc.robot.Constants;

public class ArmSubsystem {
    private final SparkMax armMotor = new SparkMax(Constants.ArmConstants.ArmMotorID, MotorType.kBrushless);
    

    public ArmSubsystem() {
        //armMotor.setInverted(true);
        //armEncoder.setPosition(0);
    }

    public void moveArm(double speed) {
        armMotor.set(0.1 * speed);
    }

    public void stopArm() {
        //armMotor.stopMotor();
    }
    
}
