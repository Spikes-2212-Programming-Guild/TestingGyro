package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.PIDCalculator.AbsoluteTolerance;

public class PIDTurnDriveByAngle extends PIDCommand {

	private static final double KP = 1;
	private static final double KI = 0;
	private static final double KD = 0;
	private static final double ABSOLUTE_TOLERANCE = 2; // degree

	public PIDTurnDriveByAngle(double kp, double angle) {
		super(kp, 0, 0, angle, new AbsoluteTolerance(ABSOLUTE_TOLERANCE));
	}

	@Override
	public double getPIDInput() {
		return Robot.gyro.getAngle();
	}

	@Override
	public void usePIDOutput(double output) {
		Robot.drive.arcadeDrive(0, output);
	}

	@Override
	protected void initialize() {
		Robot.gyro.reset();
	}

	@Override
	protected void end() {

	}

}
