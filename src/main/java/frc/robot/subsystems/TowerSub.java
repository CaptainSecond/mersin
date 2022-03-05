/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.MotorsConstants;


public class TowerSub extends SubsystemBase {

  public static final WPI_VictorSPX m_tower = new WPI_VictorSPX(MotorsConstants.TowerMotorP);
  public static final WPI_VictorSPX m_tower1 = new WPI_VictorSPX(MotorsConstants.TowerMotorP1);

  public TowerSub() {
    m_tower.configFactoryDefault();
    m_tower1.configFactoryDefault();
    //CANSparkMax m_tower;
    //m_tower= new CANSparkMax(52, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runTower(double speed) {
    m_tower.set(speed);
    m_tower1.set(speed);
  }

  public void runTowerDis(double speed) {
    m_tower.set(-speed);
    m_tower1.set(-speed);
  }

  public void stopTower() {
    m_tower.set(0);
    m_tower1.set(0);
  }
}
