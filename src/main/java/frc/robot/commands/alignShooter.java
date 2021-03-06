/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Limelight;
import frc.robot.Limelight.LightMode;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AlignShooter extends SequentialCommandGroup {
  /**
   * Creates a new alignShooter.
   */
  
  public AlignShooter(Shooter shooter, DriveTrain driveTrain) {
    super(new InstantCommand(() -> Limelight.setLedMode(LightMode.eOn)), new ApproachTarget(shooter, driveTrain), new TurnToTarget(driveTrain));
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    // super(new ShootBall(shooter), new  );

  }


}
