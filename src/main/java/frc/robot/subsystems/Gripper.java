/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Gripper extends SubsystemBase {

  private WPI_TalonSRX lGripper, rGripper;
  /**
   * Creates a new Gripper.
   */
  public Gripper() {
    lGripper = new WPI_TalonSRX(RobotMap.LEFT_GRIPPER_ID);
    rGripper = new WPI_TalonSRX(RobotMap.RIGHT_GRIPPER_ID);
    lGripper.setInverted(true);
  }

  public void intake()
  {
    move(Constants.INTAKE_SPEED);
  }

  public void outtake()
  {
    move(Constants.OUTTAKE_SPEED);
  }

  private void move(double speed)
  {
    lGripper.set(speed);
    rGripper.set(speed);
  }

  public void stop()
  {
    lGripper.stopMotor();
    rGripper.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
