// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyorsSubsystem extends SubsystemBase {
  /** Creates a new ConveyorsSubsystem. */
  //instantiate motors for the conveyors
  VictorSP leftConveyor = new VictorSP(Constants.pwmLeftConveyor);
  VictorSP rightConveyor = new VictorSP(Constants.pwmRightConveyor);
  
  public ConveyorsSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
