// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

//imports


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    //controller stuff
    public final static int controllerPort = 0;

    //PWM port locations 

    //Drivetrain controller pwm ports (on RoboRIO)
    public final static int pwmLeftFront = 0;
    public final static int pwmLeftBack = 1; 
    public final static int pwmRightFront = 2; 
    public final static int pwmRightBack = 3; 

    //Intake controller pwm ports (on RoboRIO)
    public final static int pwmIntakeTop = 4;
    public final static int pwmIntakeBottom = 5;

    //flywheel controller pwm ports (on RoboRIO)
    public final static int pwmFlywheel = 6;
    

    // color sensor test port

    public final static I2C.Port i2cPort = I2C.Port.kOnboard;

    //conveyor ports
    public static final int pwmLeftConveyor = 7;

    public static final int pwmRightConveyor = 8;

    //alliance constants
    //detect alliance from driver station
    public static Alliance alliance = DriverStation.getAlliance();

    //pwm ports for the linear actuator based arm (on RoboRIO)
    public static final int pwmArm = 9; //note this is on the MXP expansion port
    

    

}
