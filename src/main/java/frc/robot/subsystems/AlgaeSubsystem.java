package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AlgaeSubsystem extends SubsystemBase {
    SparkMax algaeMotor = new SparkMax(Constants.AlgaetConstants.AlgaeMotorID, MotorType.kBrushed);
    
      public AlgaeSubsystem() {
        //armMotor.setInverted(true);
        //armEncoder.setPosition(0);
    }

    public void movealgae(double speed) {                
        algaeMotor.set(speed);
    
    }

    public Command runAlage(AlgaeSubsystem algae, double speed) {
        return new Command() {
            @Override
            public void initialize() {
                movealgae(speed);
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
    
    }

    public void stopArm() {
        algaeMotor.stopMotor();
    }


}
