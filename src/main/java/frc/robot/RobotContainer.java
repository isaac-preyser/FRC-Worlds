// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.LowerArm;
import frc.robot.commands.RaiseArm;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.StopArm;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.ConveyorsSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static PowerDistribution powerDist = new PowerDistribution(); //import PDP object. .


  //instantiate subsystems for the whole robot here 

  //code hehe
  public static XboxController controller = new XboxController(Constants.controllerPort); //instantiate new xbox controller


  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  public final static DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  public final static ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  public final static CameraSubsystem m_cameraSubsystem = new CameraSubsystem();

  public final static ColorSubsystem m_colorSubsystem = new ColorSubsystem();

  public final static ConveyorsSubsystem m_conveyorsSubsystem = new ConveyorsSubsystem();
  public final static ArmSubsystem m_armSubsystem = new ArmSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final static ShootCommand m_ShootCommand = new ShootCommand(m_shooterSubsystem);
  private final IntakeOn m_IntakeOn = new IntakeOn(/*m_IntakeSubsystem*/);
  private final RaiseArm m_RaiseArm = new RaiseArm(m_armSubsystem);
  private final LowerArm m_LowerArm = new LowerArm(m_armSubsystem);
  private final StopArm m_StopArm = new StopArm(m_armSubsystem);
  private final IntakeOff m_IntakeOff = new IntakeOff();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //configure THE BUTTONS

    //TO-DO
    //Conveyors- Backwards, Forwards (possibly use right stick Y-axis for this)
    //Intake Toggle
    //Potentially go buy an elgato stream deck, and use it as a subsystem monitoring station / toggles for things like the top of the intake arm coming down etc
    // could be done with this: https://github.com/Snarr/FRC-Deck
    //Intake Arm Raising/Lowering
    //Flywheel Control
    //Lift Arm Control
    //..
    /*********************************************************/

    //turn on the intake when the b button is pressed
    new JoystickButton(controller, 2).whileActiveOnce(m_IntakeOn);
    new JoystickButton(controller, 2).whenInactive(m_IntakeOff);

    //shoot when the x button is pressed
    new JoystickButton(controller, 3).whenPressed(m_ShootCommand);

    //when the left bumper is pressed, run the intake backwards
    

    //when the left bumper is pressed, raise the arm
    new JoystickButton(controller, 5).whenHeld(m_RaiseArm, true).whenReleased(m_StopArm);


    
    //when the right bumper is pressed, lower the arm
    new JoystickButton(controller, 6).whenHeld(m_LowerArm, true).whenReleased(m_StopArm);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static Command getShootCommand() {
    return m_ShootCommand;
  }
}
