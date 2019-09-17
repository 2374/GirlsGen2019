package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeTeleop extends Command {

	public IntakeTeleop() {
		requires (Robot.getIntake());
	}
	
	@Override
	protected void execute() {
		if (Robot.getInput().getLeftBumper()) {
			//Move super duper fast.
			Robot.getIntake().move(RobotMap.SPEED_INTAKE, 1);
		} else if (Robot.getInput().getRightBumper()) {
			//Move super duper fast in the opposite direction.
			Robot.getIntake().move(RobotMap.SPEED_INTAKE, -1);
		} else {
			//But we don't want it move if we haven't pressed anything.
			Robot.getIntake().move(0.0, 1);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;	
	}
	
}
