/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class DriveCom extends CommandBase {
  public static DriveSub m_drive;
  public static DoubleSupplier m_forward;
  public static DoubleSupplier m_rotation;
  public static DoubleSupplier m_speed;
  public static DoubleSupplier m_speedX;
  

  public DriveCom(final DriveSub subsystem, final DoubleSupplier fwd, final DoubleSupplier rttn, final DoubleSupplier speed, final DoubleSupplier speedX) {
    m_drive = subsystem;
    m_forward = fwd;
    m_rotation = rttn;
    m_speed = speed;
    m_speedX = speedX;
    addRequirements(m_drive);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
    m_drive.speedDrive(m_speed.getAsDouble(), m_speedX.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
