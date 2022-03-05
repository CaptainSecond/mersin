/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class Kanca extends CommandBase {
  /**
   * Creates a new Kanca.
   */
  public static Climber m_climb = new Climber();
  public static double speed;
  public Kanca(Climber ms, double aspeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_climb = ms;
    speed = aspeed;
    addRequirements(ms);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_climb.DriveKanca(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_climb.DriveKanca(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climb.DriveKanca(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
