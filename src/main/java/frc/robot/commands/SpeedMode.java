package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SpeedMode extends Command {

    private boolean isSpeeding;

    public SpeedMode(boolean isSpeeding) {
        this.isSpeeding = isSpeeding;
    }

    @Override
    protected void initialize() {
        System.out.println("[Debug] Robot speeding toggled to: " + isSpeeding);
    }

    @Override
    protected void execute() {
        Robot.getInput().setSpeeding(isSpeeding);
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
        
    }

}