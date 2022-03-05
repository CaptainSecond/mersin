/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
    public static class General{

        public static Double x;
        public static boolean z = true;
        public static final int gLedP = 3;
        public static Double s;

    }
    public static class JoystickConstants{

        public static final int driverJoyP = 0;
        public static final int coDriverJoyP = 1;

    }
    public static class MotorsConstants{

        //şase  motors                           
        public static final int SagMasterP = 10;
        public static final int SagSlaveP = 2;
        public static final int SolMasterP = 5;
        public static final int SolSlaveP =13;
        //Intake motors
        public static final int IntakeMotorP = 3;
        //Tower motors
        public static final int TowerMotorP = 222;
        public static final int TowerMotorP1 = 3;
        //Shooter motors
        public static final int ShootMotor1P = 355;

     public static final int TurretCom =4442;
        //Turret motors
        public static final int TurretMotorP =442;

        public static final int TirmanmaP =8;
        public static final int TirmanmaKancaP = 8;

        public static int xeksen = 0;
        public static int yeksen = 0;

    }

}
