/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.Cerealizer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Cerealizer.Mode;
import frc.robot.subsystems.Shooter.HoodPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootBall extends SequentialCommandGroup {
  /**
   * Creates a new ShootBall.
   */

  public ShootBall(Shooter shooter, Cerealizer cerealizer) {

    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new WaitForShooterReady(shooter), parallel(new SpinCerealizer(cerealizer),
        new StartEndCommand(() -> cerealizer.startEjectMotor(), () -> cerealizer.stopEjectMotor())));
  }
}
// new RunCommand(()->cerealizer.startEjectMotor(), cerealizer).withTimeout(5)