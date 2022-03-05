package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.MotorsConstants;

public class TurretSub extends SubsystemBase {

  public static final WPI_VictorSPX turretm = new WPI_VictorSPX(MotorsConstants.TurretMotorP);

  public TurretSub() {
    turretm.configFactoryDefault();
  }

  @Override
  public void periodic() {
  }

  public void runTurret(double speed){
    turretm.set(speed);
  }

  public void stopTurret(){
    turretm.set(0);
  }
  
}
