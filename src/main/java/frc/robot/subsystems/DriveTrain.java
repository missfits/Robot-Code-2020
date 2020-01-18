/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  final CANSparkMax frontLeft = new CANSparkMax(7, MotorType.kBrushless);
  final CANSparkMax frontRight = new CANSparkMax(2, MotorType.kBrushless);
  final CANSparkMax middleLeft = new CANSparkMax(3, MotorType.kBrushless);
  final CANSparkMax middleRight = new CANSparkMax(4, MotorType.kBrushless);
  final CANSparkMax backLeft = new CANSparkMax(5, MotorType.kBrushless);
  final CANSparkMax backRight = new CANSparkMax(6, MotorType.kBrushless);

  DifferentialDrive driveTrain;

  public DriveTrain() {
    middleLeft.follow(frontLeft);
    backLeft.follow(frontLeft);
    middleRight.follow(frontRight);
    backRight.follow(frontRight);

    frontLeft.setInverted(true);

    driveTrain = new DifferentialDrive(frontLeft, frontRight);
    driveTrain.setDeadband(0.1);
  }

  public void setSpeed(double leftSpeed, double rightSpeed){
    /*frontRight.set(rightSpeed);
    frontLeft.set(leftSpeed);*/
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
