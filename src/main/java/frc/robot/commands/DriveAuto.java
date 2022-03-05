/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.TowerSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveAuto extends SequentialCommandGroup {


  /**
   * Creates a new DriveAuto.
   */
  public DriveAuto(DriveSub driveTrain,TowerSub m_sub, IntakeSub t_sub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(

    );
    addCommands(
        // Drive straight fast
        new DriveSt(driveTrain, 0.8, 0),      // driveTrain , Bos, Bos
        new ShooterTimer(m_sub, 1, true), // hiz - devamlilik
       new ShooterTimer(m_sub, 1, false),// hiz - devamlilik
        new KanalParalel(t_sub, -1, 4), // hiz - süre
        new ShooterTimer(m_sub, 0, true)// hiz - devamlilik
    );
  }
}
