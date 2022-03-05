// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSub extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  //public static final WPI_VictorSPX m_tower = new WPI_VictorSPX(MotorsConstants.ShootMotor1P);
  CANSparkMax m_tower;
  CANSparkMax Rshootermotor;
  public ShootSub() {
    m_tower= new CANSparkMax(52, MotorType.kBrushless);
    m_tower= new CANSparkMax(51, MotorType.kBrushless);
    
  }

  public void  m_tower(double speed){
    m_tower.set(speed);
  }

  public void  m_tower1(double speed){
    m_tower.set(speed);
  }
  public void stopm_tower(){
    m_tower.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
