/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorsConstants;
import frc.robot.commands.AutoCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  ShootSub shooter = new ShootSub();
  DriveSub drive = new DriveSub();
  TowerSub tower = new TowerSub();
  public static final WPI_VictorSPX tirmanma = new WPI_VictorSPX(MotorsConstants.TirmanmaP);
  public static final WPI_VictorSPX kanca = new WPI_VictorSPX(MotorsConstants.TirmanmaKancaP);
  public Climber() {
    tirmanma.configFactoryDefault();
    kanca.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void DriveClimb(final double speed) {
    tirmanma.set(speed);
  }

  public void DriveKanca(final double speed) {
    kanca.set(speed);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @param robotContainer TODO
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(final RobotContainer robotContainer) {
    // An ExampleCommand will run in autonomous
    // return m_driveStraightAutonomous;
    // return m_driveLeftAutonomous;
    // return m_driveRightAutonomous;

    // Galactic Search
    // return new OnePowerCell(m_hopperSubsystem, m_intakeSubsystem, m_shooterSubsystem, m_driveTrain);

    //return robotContainer.m_driveStraightAutonomous2;
    return new AutoCommand(shooter, tower, drive);
  }
}
