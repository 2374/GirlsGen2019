package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ThrowBall extends Command {

    public ThrowBall(int timeout) {
        requires (Robot.getDrivetrain());
        requires (Robot.getIntake());

        super.setTimeout(timeout);
    }

    @Override
    protected void initialize() {
        System.out.println("[Debug] Throwing a ball.");
    }

    @Override
    protected void execute() {
        Robot.getIntake().move(0.5, 1);
        Robot.getElevator().move(RobotMap.ELEVATOR_BRAKE, 1);
    }

    @Override
    protected boolean isFinished() {
        return super.isTimedOut();
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        Robot.getIntake().move(0.0, 1);
    }

}