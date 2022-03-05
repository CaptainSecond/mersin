// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Climb;
import frc.robot.commands.ClimbDis;
import frc.robot.commands.DriveAuto;
import frc.robot.commands.DriveCom;
import frc.robot.commands.IntakeCom;
import frc.robot.commands.Kanca;
import frc.robot.commands.KancaDis;
import frc.robot.commands.ShootCom;
import frc.robot.commands.TowerCom;
import frc.robot.commands.TowerDisCom;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.ShootSub;
import frc.robot.subsystems.TowerSub;
import frc.robot.subsystems.TurretSub;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick cojoy = new Joystick(0);

  private final ShootSub m_shoot = new ShootSub();

  private final TurretSub m_turret = new TurretSub();

  private final DriveSub m_driving = new DriveSub();

  private final IntakeSub m_intake = new IntakeSub();

  private final TowerSub m_tower = new TowerSub();

  public final DriveAuto m_driveStraightAutonomous2 = new DriveAuto(m_driving, m_tower, m_intake);

  final Climber climberSystem = new Climber();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    extracted();
    m_driving.setDefaultCommand(new DriveCom(m_driving, () -> -cojoy.getRawAxis(1), () -> -cojoy.getRawAxis(0),
        () -> cojoy.getRawAxis(3), () -> cojoy.getRawAxis(2))); // şasenin sürüşünü kontrol eder.
  }

  public TurretSub getM_turret() {
    return m_turret;
  }

  private void extracted() {
    configureButtonBindings(); // fonksiyonunu çağırır.
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //new JoystickButton(cojoy, 10).whileHeld(new TowerCom(m_tower, 1));  // Shooter sistemi
 
    new JoystickButton(cojoy,3).whileHeld(new ShootCom(m_shoot, 0.6));     //top atmasistemi

    //new JoystickButton(cojoy, 2).whileHeld(new TurretCom(m_turret, 1));  //Taretin donusu
    //new JoystickButton(cojoy, 3).whileHeld(new TurretCom(m_turret, -1)); //Tartin donusu

    new JoystickButton(cojoy, 1).whileHeld(new IntakeCom(m_intake, 1));   //intake sistemi.
    new JoystickButton(cojoy, 4).whileHeld(new IntakeCom(m_intake, -0.7)); 
    new POVButton(cojoy, 15).whenHeld(new TowerCom(m_tower,-1)); 
    new POVButton(cojoy, 45).whenHeld(new TowerCom(m_tower,-1));// shooter
    new POVButton(cojoy, 35).whenHeld(new TowerDisCom(m_tower,-1)); // shooter
    new POVButton(cojoy, 21).whenHeld(new IntakeCom(m_intake,1));
    new POVButton(cojoy, 24).whenHeld(new IntakeCom(m_intake,-1));

    // Tuş türü ( Joystick , Sirasi). whenHeld(çalışacağı sistem)


    new JoystickButton(cojoy, 5).whileHeld(new Climb(climberSystem, 1));   //tirmanma
    new JoystickButton(cojoy,6 ).whileHeld(new ClimbDis(climberSystem, -1));   //tirmanma
    new POVButton(cojoy, 90).whenHeld(new Kanca(climberSystem,1)); // kanca
    new POVButton(cojoy, 270).whenHeld(new KancaDis(climberSystem,-1)); // kanca
    new JoystickButton(cojoy, 10).whileHeld(new Kanca(climberSystem, -1));   //topun çıkış hızını tayın eder.
    //top alma mekanizmasının hızını tayin eder.

  }
}
