package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.PIDCalculator.Tolerance;

import edu.wpi.first.wpilibj.command.Command;

public abstract class PIDCommand extends Command {

	private PIDCalculator calculator;

	public PIDCommand(double kp, double ki, double kd, double setpoint, Tolerance tolerance) {
		calculator = new PIDCalculator(kp, ki, kd);
		calculator.setSetpoint(setpoint);
		calculator.setTolerance(tolerance);
	}

	public abstract double getPIDInput();

	public abstract void usePIDOutput(double output);

	@Override
	protected void execute() {
		usePIDOutput(calculator.calculate(getPIDInput()));
	}

	@Override
	protected boolean isFinished() {
		return calculator.hasReached();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
