package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainTeleop extends Command {

	public DrivetrainTeleop() {
		requires (Robot.getDrivetrain());
	}
	
	@Override
	protected void execute() {
		if (Robot.getInput().getButtonA()) {
			if (Robot.getLidar().getDistanceCm() > RobotMap.STOP_DISTANCE) {
				Robot.getLimeLight().updateTracking(false);
				if (Robot.getLimeLight().hasValidTarget()) {
					Robot.getDrivetrain().arcadeDrive(-Robot.getLimeLight().getThrottle(), Robot.getLimeLight().getSteer());
				} else {
					Robot.getDrivetrain().arcadeDrive(0.0, 0.0);
				}
			}
		} else if (Robot.getInput().getButtonB()) {
			System.out.println(Robot.getElevator().getTicks());
		} else if (Robot.getInput().getButtonX()) {
			Robot.getInput().setSpeeding(!Robot.getInput().isSpeeding());
		} else if (Robot.getInput().getLeftTrigger() > 0.0) {
			Robot.getDrivetrain().tankDrive(Robot.getInput().getLeftTrigger(), Robot.getInput().getLeftTrigger());
		} else if (Robot.getInput().getRightTrigger() > 0.0) {
			Robot.getDrivetrain().tankDrive(-Robot.getInput().getRightTrigger(), -Robot.getInput().getRightTrigger());
		} else {
			//Robot.getDrivetrain().tankDrive(Robot.getInput().getJoystickLeftY(), Robot.getInput().getJoystickRightY());
			if (Robot.getInput().isSpeeding()) {
				Robot.getDrivetrain().arcadeDrive(Robot.getInput().getJoystickLeftY(), Robot.getInput().getJoystickLeftX());
			} else {
				Robot.getDrivetrain().arcadeDrive(Robot.getInput().getJoystickLeftY(), Robot.getInput().getJoystickLeftX(), 1.2, 2.0);		
			}
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
