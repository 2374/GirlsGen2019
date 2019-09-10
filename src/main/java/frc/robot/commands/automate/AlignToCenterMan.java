package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AlignToCenterMan extends Command {

    public AlignToCenterMan() {
        requires (Robot.getDrivetrain());
    }

    @Override
    protected void initialize() {
        System.out.println("[Debug] Robot currently aligning to center (MANUALLY!).");
    }

    @Override
    protected void execute() {
        if (Robot.getLidar().getDistanceCm() > RobotMap.STOP_DISTANCE) {
            Robot.getLimeLight().updateTracking(false);
            if (Robot.getLimeLight().hasValidTarget()) {
                Robot.getDrivetrain().arcadeDrive(-Robot.getLimeLight().getThrottle(), Robot.getLimeLight().getSteer());
            } else {
                Robot.getDrivetrain().arcadeDrive(0.0, 0.0);
            }
        }
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