/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.ShootSub;
import frc.robot.subsystems.TowerSub;

public class ShooterAuto extends CommandBase {
  /**
   * Creates a new ShooterAuto.
   */
  private final TowerSub m_sub;
  private double m_speed;
  private boolean m_bool;
  public ShooterAuto(TowerSub sub,double speed, boolean durum) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_sub = sub;
    m_speed = speed;
    m_bool = durum;
    addRequirements(sub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(m_bool){
      m_sub.stopTower();
      System.out.println("abcxxx");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_sub.runTower(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(m_bool){
      m_sub.stopTower();
      System.out.println("abc");
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
