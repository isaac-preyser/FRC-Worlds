// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  VictorSP leftShooter = new VictorSP(Constants.pwmBucketLeft);
  VictorSP rightShooter = new VictorSP(Constants.pwmBucketRight);

  DifferentialDrive shooter = new DifferentialDrive(leftShooter, rightShooter);

  public ShooterSubsystem() {

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //might need to invert one motor..

    
  }

  public void shoot() {
    shooter.arcadeDrive(1, 0);
  }
}
