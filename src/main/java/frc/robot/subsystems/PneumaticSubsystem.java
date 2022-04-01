// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticSubsystem extends SubsystemBase {
  /** Creates a new PneumaticSubsystem. */

  //instatniate double solenoid 
  DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  
  

  public PneumaticSubsystem() {
    solenoid.set(DoubleSolenoid.Value.kReverse);


  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extend() {
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }
  
}
