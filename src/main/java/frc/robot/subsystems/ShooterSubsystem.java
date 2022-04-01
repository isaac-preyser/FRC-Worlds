// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.module.ModuleDescriptor.Requires;


import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  int intakeReduce = 5;
  //instantiate motor for a single flywheel shooter
  VictorSP flywheel = new VictorSP(Constants.pwmFlywheel);

  //instantiate motors for the intake
  VictorSP intakeBottom = new VictorSP(Constants.pwmIntakeBottom);
  VictorSP intakeTop = new VictorSP(Constants.pwmIntakeTop);
  

  public ShooterSubsystem() {
    intakeBottom.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //might need to invert one motor..
    
    
  }

  public void spinFlywheel() {
    //spin up flywheel
    flywheel.set(1);
  }

  public void stopFlywheel() {
    //stop flywheel
    flywheel.set(0);
  }

  public void spinIntake(boolean inverted) {
    if (inverted) {
      intakeTop.set(1);
      intakeBottom.set(1);
    } else {
      intakeTop.set(-1);
      intakeBottom.set(-1);
    }
  }
  public void stopIntake() {
    intakeTop.set(0);
    intakeBottom.set(0);
  }
}
