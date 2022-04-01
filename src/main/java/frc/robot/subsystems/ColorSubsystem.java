// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class ColorSubsystem extends SubsystemBase {
  /** Creates a new ColorSubsystem. */

  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(Constants.i2cPort);

  private final ColorMatch m_colorMatcher = new ColorMatch();

  IntakeOff m_IntakeOff = new IntakeOff();

  IntakeOn m_IntakeOn = new IntakeOn();
  //import colors 

  private final Color kBlueTarget = new Color(0.232, 0.458, 0.309);
 // private final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
  private final Color kRedTarget = new Color(0.35, 0.435, 0.21);
  private final Color kYellowTarget = new Color(0.293, 0.475, 0.231);

  public ColorSubsystem() {
    m_colorMatcher.addColorMatch(kBlueTarget);

    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //most of this is stolen from REV Robotics
    Color detectedColor = m_colorSensor.getColor();

    /**
     * Run the color match algorithm on our detected color
     */
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
      if (Constants.alliance == Alliance.Red && match.confidence > 0.7) {
        //prevent the intake from taking in the ball
        m_IntakeOff.schedule();
      } else {
        m_IntakeOn.schedule();
      }
    } else if (match.color == kRedTarget) {
      colorString = "Red";
      if (Constants.alliance == Alliance.Blue && match.confidence > 0.7) {
        //prevent the intake from taking in the ball
        
        m_IntakeOff.schedule();
      } else {
        m_IntakeOn.schedule();
      }
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
      m_IntakeOff.schedule();
      }
    else {
      colorString = "Unknown";
    }

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);


  }
}
