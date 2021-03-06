/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.TowerSub;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:

// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html



public class ShooterTimer extends ParallelRaceGroup {
  
  /**
   * Creates a new ShooterTimer.
   */
  public ShooterTimer(TowerSub sub, double speed, boolean durum) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super();
    addCommands(
      new ShooterAuto(sub, speed, durum),
      new WaitCommand(4)
    );
  }
}
