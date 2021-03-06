/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Arm extends SubsystemBase {
  private WPI_TalonSRX leftDart, rightDart;
  /**
   * Creates a new Arm.
   */
  public Arm() {
    leftDart = new WPI_TalonSRX(RobotMap.LEFT_DART_ID);
    rightDart = new WPI_TalonSRX(RobotMap.RIGHT_DART_ID);
    rightDart.set(ControlMode.Follower, RobotMap.LEFT_DART_ID);
  }

  public void move(double speed)
  {
    leftDart.set(speed);
  }


  public void stop()
  {
    leftDart.stopMotor();
  }

  @Override
  public void periodic() {
    leftDart.set(0.1);
    // This method will be called once per scheduler run
  }
}
