package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class DeployHatch extends CommandGroup {

    public DeployHatch(int level) {
        requires (Robot.getDrivetrain());
        requires (Robot.getElevator());

        //addSequential(new AlignToCenter(false), 5);
        //addSequential(new MoveToPoint(RobotMap.STOP_DISTANCE, 1));
        // addSequential(new MoveElevatorToPoint(level));
        // addSequential(new PlaceHatch());
        // addSequential(new MoveToPoint(RobotMap.STOP_IDEAL_STOP_DISTANCE, -1));
        // addSequential(new MoveElevatorToPoint(RobotMap.ELEVATOR_HATCH_1_DEPLOY));

        addSequential(new MoveElevatorToPoint(level));

    }

}