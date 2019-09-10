package frc.robot.commands.automate;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AlignToCenter extends Command {

    private boolean isBall;
    private boolean finished;

    public AlignToCenter(boolean isBall) {
        requires (Robot.getDrivetrain());

        this.isBall = isBall;
    }

    @Override
    protected void initialize() {
        System.out.println("[Debug] Robot currently aligning to center.");
    }

    @Override
    protected void execute() {
        // potentially change from while to if. IF THERE ARE ISSUES -> yep, I changed it to if
        while (Robot.getLidar().getDistanceCm() > RobotMap.STOP_DISTANCE) {
            Robot.getLimeLight().updateTracking(isBall);
            if (Robot.getLimeLight().hasValidTarget()) {
                Robot.getDrivetrain().arcadeDrive(-Robot.getLimeLight().getThrottle(), Robot.getLimeLight().getSteer());
            } else {
                Robot.getDrivetrain().arcadeDrive(0.0, 0.0);
            }
        }
        finished = true;
    }

    @Override
    protected boolean isFinished() {
        return finished;
    }

    @Override
    protected void interrupted() {

    }

    @Override
    protected void end() {
        Robot.getDrivetrain().tankDrive(0.0, 0.0);
    }

}