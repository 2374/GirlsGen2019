package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;

public class Climber {

    private DoubleSolenoid solenoid;

    public Climber() {
        this.solenoid = new DoubleSolenoid(RobotMap.CLIMBER_PORT_FORWARD, RobotMap.CLIMBER_PORT_REVERSE);
    }

    public DoubleSolenoid getPiston() { return solenoid; }

}