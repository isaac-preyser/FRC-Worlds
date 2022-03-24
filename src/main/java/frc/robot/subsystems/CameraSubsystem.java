// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class CameraSubsystem extends SubsystemBase {
  /** Creates a new CameraSubsystem. */

  public CameraSubsystem() {
    // Use addRequirements() here to declare subsystem dependencies.
    //start opencv thread
    new Thread(() -> {
      // Load the native library.
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
      // Create a new VideoCapture object
      VideoCapture camera = new VideoCapture();
      // Open the camera
      camera.open(0);
      // Check if we have opened the camera
      if (camera.isOpened()) {
        // Create a new Mat object
        Mat frame = new Mat();
        // Read the current frame
        camera.read(frame);
        // Show the current frame
        // Imgcodecs.imwrite("/home/lvuser/frame.jpg", frame);
        // System.out.println("Saved frame");
        // Release the current frame
        frame.release();
      }
      // Release the VideoCapture object
      camera.release();
    }).start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
