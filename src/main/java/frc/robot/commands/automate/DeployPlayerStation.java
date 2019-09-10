package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.automate.MoveElevatorToPoint;

public class DeployPlayerStation extends CommandGroup {

    public DeployPlayerStation() {
        requires (Robot.getDrivetrain());
        requires (Robot.getElevator());

        addSequential(new MoveElevatorToPoint(RobotMap.ELEVATOR_HATCH_1));
        addSequential(new AlignToCenter(false));
        addSequential(new MoveToPoint(RobotMap.STOP_PLAYERSTATION_DISTANCE, 1));
        addSequential(new MoveElevatorToPoint(RobotMap.ELEVATOR_HATCH_1 + RobotMap.DEPLOY_OFFSET));
        addSequential(new MoveToPoint(RobotMap.STOP_DISTANCE, 1));
        addSequential(new MoveElevatorToPoint(RobotMap.ELEVATOR_HATCH_1));

    }

}