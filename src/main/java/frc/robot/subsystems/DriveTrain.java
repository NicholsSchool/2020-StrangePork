/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  
  private WPI_TalonSRX lFDrive, lMDrive, lBDrive, 
                       rFDrive, rMDrive, rBDrive;
  private DifferentialDrive drive;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
      lFDrive = new WPI_TalonSRX(RobotMap.LEFT_FRONT_DRIVE_ID);
      lMDrive = new WPI_TalonSRX(RobotMap.LEFT_MID_DRIVE_ID);
      lBDrive = new WPI_TalonSRX(RobotMap.LEFT_BACK_DRIVE_ID);
      rFDrive = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_DRIVE_ID);
      rMDrive = new WPI_TalonSRX(RobotMap.RIGHT_MID_DRIVE_ID);
      rBDrive = new WPI_TalonSRX(RobotMap.RIGHT_BACK_DRIVE_ID);

    lFDrive.setInverted(true);
    lMDrive.setInverted(true);
    lBDrive.setInverted(true);

    rFDrive.setInverted(false);
    rMDrive.setInverted(true);
    rBDrive.setInverted(true);

    lFDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    lMDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    lBDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    lFDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    rMDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    rBDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);

    lFDrive.setSensorPhase(true);
    lMDrive.setSensorPhase(true);
    lBDrive.setSensorPhase(true);

    rFDrive.setSensorPhase(true);
    rMDrive.setSensorPhase(false);
    rBDrive.setSensorPhase(false);

      drive = new DifferentialDrive(new SpeedControllerGroup(lFDrive, lMDrive, lBDrive),
       new SpeedControllerGroup(rFDrive, rMDrive, rBDrive));
  }

  public void move(double leftSpeed, double rightSpeed)
  {
      drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void stop()
  {
    drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    SmartDashboard.putNumber("NAVX: ", RobotContainer.navX.getAngle());
  }
}
