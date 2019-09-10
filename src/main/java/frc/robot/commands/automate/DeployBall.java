package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DeployBall extends CommandGroup {

    public DeployBall(int level) {
        requires (Robot.getDrivetrain());
        requires (Robot.getElevator());

        addSequential(new AlignToCenter(true));
        addSequential(new MoveElevatorToPoint(level));
        addSequential(new MoveToPoint(RobotMap.STOP_DISTANCE, 1));
        addSequential(new ThrowBall(1));
        addSequential(new MoveElevatorToPoint(RobotMap.ELEVATOR_HATCH_1));
    }

}