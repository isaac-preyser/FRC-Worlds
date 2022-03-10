

//this subsystem will contain all the different methods needed to make the drivetrain drive. 
// I plan on adding basic arcadeDrive functionality, as Sean (the driver) prefers it over curvatureDrive.
// This is also the place where I will instantiate the motor controllers and controller groups. 


//initial subsystem setup and imports. 
package frc.robot.subsystems; 

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    /*create a new DriveSubsytem*/

    Spark s_leftFront = null;
    Spark s_leftBack = null;
    Spark s_rightFront = null;
    Spark s_rightBack = null; 

    MotorControllerGroup leftMotors = null; 
    MotorControllerGroup rightMotors = null;

    DifferentialDrive diffDrive = null;

    //values of joystick inputs 

    double leftJoy = 0;
    double rightJoy = 0;

    XboxController controller = null; 
    
    

    public DriveSubsystem() {
        //code here

        XboxController controller = new XboxController(Constants.controllerPort); //instantiate new xbox controller
       

        

       //construct new spark objects 
        Spark s_leftFront = new Spark(Constants.pwmLeftFront);
        Spark s_leftBack = new Spark(Constants.pwmLeftBack);
        Spark s_rightFront = new Spark(Constants.pwmRightFront);
        Spark s_rightBack = new Spark(Constants.pwmRightBack);

        try (MotorControllerGroup leftMotors = new MotorControllerGroup(s_leftFront, s_leftBack)) {
        }
        try (MotorControllerGroup rightMotors = new MotorControllerGroup(s_rightFront, s_rightBack)) {
            rightMotors.setInverted(true); //must invert the right side, according to API changelog. 
        }

        //start diffDrive

        try (DifferentialDrive diffDrive = new DifferentialDrive(leftMotors, rightMotors)) {
             
        } 


    }

    public void Drive(double speed, double turn) {
        diffDrive.arcadeDrive(speed, turn);
        leftJoy = controller.getLeftY(); //set the value of the joystick to the Y-axis of the left joystick
        rightJoy = controller.getRightX(); //set the value of the joystick to the X-axis of the right joystick. 
        
        
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

