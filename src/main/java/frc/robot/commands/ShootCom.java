/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSub;
import frc.robot.subsystems.TowerSub;

public class ShootCom extends CommandBase {
  ShootSub m_shoot;
  Double m_speed;

  public ShootCom(ShootSub susystem, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shoot = susystem;
    m_speed = speed;
    addRequirements(m_shoot);
  }

  public ShootCom(TowerSub m_sub, int i, boolean b) {
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shoot. m_tower(m_speed);
    m_shoot. m_tower(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shoot. m_tower(0);
    m_shoot. m_tower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
