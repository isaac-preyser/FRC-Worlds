

//this subsystem will contain all the different methods needed to make the drivetrain drive. 
// I plan on adding basic arcadeDrive functionality, as Sean (the driver) prefers it over curvatureDrive.
// This is also the place where I will instantiate the motor controllers and controller groups. 


//initial subsystem setup and imports. 
package frc.robot.subsystems; 

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveSubsystem extends SubsystemBase {
    /*create a new DriveSubsytem*/


    //construct new spark objects 
    Spark s_leftFront = new Spark(Constants.pwmLeftFront);
    Spark s_leftBack = new Spark(Constants.pwmLeftBack);
    Spark s_rightFront = new Spark(Constants.pwmRightFront);
    Spark s_rightBack = new Spark(Constants.pwmRightBack);
 

    MotorControllerGroup leftMotors = new MotorControllerGroup(s_leftFront, s_leftBack); 

    MotorControllerGroup rightMotors = new MotorControllerGroup(s_rightFront, s_rightBack);

    DifferentialDrive diffDrive = new DifferentialDrive(leftMotors, rightMotors);

    //values of joystick inputs 

    double leftJoy = 0;
    double rightJoy = 0;

     
    
    

    public DriveSubsystem() {
        //code here

        //start diffDrive

        rightMotors.setInverted(true);
    }

    public void drive(double speed, double turn) {
        diffDrive.arcadeDrive(speed, turn);
        leftJoy = RobotContainer.controller.getLeftY(); //set the value of the joystick to the Y-axis of the left joystick
        rightJoy = RobotContainer.controller.getRightX(); //set the value of the joystick to the X-axis of the right joystick. 
        
        
    }

    @Override
    public void periodic() {
        //this method updated periodically, once per scheduler run..

    }

    @Override
    public void simulationPeriodic() {
        //I doubt I'll get to simulation at this point, but any monitoring would go here. 
    }
}

