/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.MotorsConstants;
import frc.robot.Constants.JoystickConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class DriveSub extends SubsystemBase {
  public static final WPI_VictorSPX sagMaster = new WPI_VictorSPX(MotorsConstants.SagMasterP);
  public static final WPI_VictorSPX solMaster = new WPI_VictorSPX(MotorsConstants.SolMasterP);
  public static final WPI_VictorSPX sagSlave = new WPI_VictorSPX(MotorsConstants.SagSlaveP);
  public static final WPI_VictorSPX solSlave = new WPI_VictorSPX(MotorsConstants.SolSlaveP);
  Solenoid exampleSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  Solenoid exampleSolenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  Solenoid exampleSolenoid3 = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
  Compressor aa = new Compressor(0, PneumaticsModuleType.CTREPCM);
  public static final DifferentialDrive drive = new DifferentialDrive(solMaster,sagMaster);

  Joystick cojoy2 = new Joystick(0);
  public static final Joystick m_joy = new Joystick(JoystickConstants.driverJoyP);

  public DriveSub() {
    solSlave.follow(solMaster);
    sagSlave.follow(sagMaster);
    
    sagMaster.configFactoryDefault();
    solMaster.configFactoryDefault();
    sagSlave.configFactoryDefault();
    solSlave.configFactoryDefault();
  }


  public void periodic() {
    //drive.setMaxOutput(1);//0,6

  
	if(cojoy2.getRawButton(2)){
      exampleSolenoid.set(true);
    }
    else{
      exampleSolenoid.set(false);
    }
    
    if(cojoy2.getRawButton(2)){
      exampleSolenoid2.set(true);
    }
    else{
      exampleSolenoid2.set(false);
    }
    
    if(cojoy2.getRawButton(2)){
      exampleSolenoid3.set(true);
    }
    else{
      exampleSolenoid3.set(false);
    }
    
  }

  public void arcadeDrive(final double fwd, final double rot) {
    drive.arcadeDrive(fwd, rot, true);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void speedDrive(final double speed, final double speedX){
    if(speed > 0.1){
      drive.setMaxOutput(1); // robot tam hizda
    }
    else if(speedX > 0.1){
      drive.setMaxOutput(0.15); // robot minimum hizda
    }
    else{
      drive.setMaxOutput(0.6); // normal hizi
    }
  }

  
}
