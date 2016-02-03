
package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	static Gyro gyro;
	VictorSP left1, left2, right1, right2;
	static RobotDrive drive;
	Command rotate;

	public void robotInit() {
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		left1 = new VictorSP(0);
		left2 = new VictorSP(1);
		right1 = new VictorSP(8);
		right2 = new VictorSP(9);
		drive = new RobotDrive(left1, left2, right1, right2);
		SmartDashboard.putNumber("kp", 0);
		SmartDashboard.putNumber("angle", 0);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {
		rotate = new PIDTurnDriveByAngle(SmartDashboard.getNumber("kp"), SmartDashboard.getNumber("angle"));
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Yaw angle", gyro.getAngle());
		SmartDashboard.putNumber("Yaw rate", gyro.getRate());

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
