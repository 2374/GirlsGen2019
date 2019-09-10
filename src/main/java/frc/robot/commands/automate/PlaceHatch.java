package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class PlaceHatch extends Command {

    public PlaceHatch() {
        requires (Robot.getDrivetrain());
        requires (Robot.getElevator());
    }

    @Override
    protected void initialize() {
        System.out.println("[Debug] Placing hatch.");
    }

    @Override
    protected void execute() {
        while (Robot.getLidar().getDistanceCm() > 30) {
            Robot.getDrivetrain().tankDrive(RobotMap.SPEED_DRIVE, RobotMap.SPEED_DRIVE);
        }
        Robot.getDrivetrain().tankDrive(0.0, 0.0);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void interrupted() {

    }

    @Override
    protected void end() {
        Robot.getDrivetrain().tankDrive(0.0, 0.0);
    }

}