package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorTeleop extends Command {

	public ElevatorTeleop() {
		requires (Robot.getElevator());
	}

	@Override
	protected void execute() {

		// Move Elevator up when M1 is pressed.
		if (Robot.getInput().getButtonM1()) {
			//Move the Elevator up when threshold is passed.
			if (Robot.getElevator().getTicks() > RobotMap.ELEVATOR_ZERO_LIMIT) {
				Robot.getElevator().move(RobotMap.SPEED_ELEVATOR / 2.0, -1);
			} else {
				Robot.getElevator().move(0.0, 1);
			}
		} else if (Robot.getInput().getButtonM2()) {
			//Move the elevator in the opposite direction.
			Robot.getElevator().move(RobotMap.SPEED_ELEVATOR, 1);
		} else {
			//But if nothing is pressed then we don't want the elevator to move at all.
			Robot.getElevator().move(RobotMap.ELEVATOR_BRAKE, 1);
		}

		// Anti-Tip using onboard gyroscope.
		if (Robot.getNavX().getRoll() > RobotMap.TIPPING_LIMIT || Robot.getNavX().getPitch() > RobotMap.TIPPING_LIMIT) {
			Robot.getDrivetrain().tankDrive(0.0, 0.0);
			Robot.getElevator().move(RobotMap.ELEVATOR_ZERO_LIMIT);
        }
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
