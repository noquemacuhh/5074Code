package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    private final SparkMax armMotor = new SparkMax(Constants.ArmConstants.ArmMotorID, MotorType.kBrushed);
    private final SparkMax armMotor2= new SparkMax(Constants.ArmConstants.ArmMotorID2, MotorType.kBrushed);
    private final SparkMaxConfig armMotorConfig = new SparkMaxConfig();
    private final SparkMaxConfig armMotorConfig2 = new SparkMaxConfig();

    public ArmSubsystem() {

        armMotorConfig2.follow(Constants.ArmConstants.ArmMotorID, true);

        armMotor.configure(armMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        armMotor2.configure(armMotorConfig2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
        //armMotor.setInverted(true);
        //armEncoder.setPosition(0);
    }

    public void moveArm(double speed) {                
        armMotor.set(speed);
    
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
        armMotor.stopMotor();
    }
    
}
