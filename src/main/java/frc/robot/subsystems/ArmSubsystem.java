// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  //instatiate the arm motor
  
  private final Spark armMotor = new Spark(Constants.pwmArm);

  public ArmSubsystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //do sensor stuff here

  }

  public void raiseArm() {
    //raise arm
    armMotor.set(1);
  }

  public void lowerArm() {
    //lower arm
    armMotor.set(-1);
  }

  public void stopArm() {
    //stop arm
    armMotor.set(0);
  }
}
