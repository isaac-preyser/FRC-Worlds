// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.I2C;

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


    //bucket test pwm ports 

    public final static int pwmBucketLeft = 5;
    public final static int pwmBucketRight = 6; 

    // color sensor test port

    public final static I2C.Port i2cPort = I2C.Port.kOnboard;

    

}
