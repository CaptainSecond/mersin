// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ShootSub;
import frc.robot.subsystems.TowerSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommand extends SequentialCommandGroup {
  /** Creates a new AutoCommand. */
  public AutoCommand(ShootSub shooter,TowerSub tower,DriveSub drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
            new RunCommand(()-> tower.runTower(1), tower),
            new RunCommand(() -> shooter.m_tower(1), shooter),
            new RunCommand(() -> shooter.m_tower1(1), shooter)
            ){
          @Override
          public void end(boolean interrupted) {
            tower.runTower(0);
            shooter.m_tower(0);
            shooter.m_tower1(0);
          }
        }.withTimeout(3),
        new ParallelCommandGroup(
          new RunCommand(() -> drive.tankDrive(-0.5, -0.5), drive)) {
        @Override
        public void end(boolean interrupted) {
          drive.tankDrive(0, 0);
        }
      }.withTimeout(2)
    );
  }
}
