/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class Climb extends CommandBase {
  /**
   * Creates a new Climb.
   */
  public static Climber m_climb = new Climber();
  public static double speed;
  public static int m_a;
  public Climb(Climber clm, double ms ) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_climb = clm;
    speed = ms;
    addRequirements(clm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_climb.DriveClimb(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_climb.DriveClimb(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climb.DriveClimb(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
