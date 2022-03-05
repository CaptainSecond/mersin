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

public class IntakeSub extends SubsystemBase {
  WPI_VictorSPX m_intake = new WPI_VictorSPX(MotorsConstants.IntakeMotorP);
  public IntakeSub() {
    m_intake.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runIntake(double speed){
    m_intake.set(speed);
  }

  public void stopIntake(){
    m_intake.set(0);
  }
}
