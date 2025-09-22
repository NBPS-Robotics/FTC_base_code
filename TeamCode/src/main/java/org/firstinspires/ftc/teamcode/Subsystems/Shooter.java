package org.firstinspires.ftc.teamcode.Subsystems;

import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController;
import com.rowanmcalpin.nextftc.core.control.controllers.feedforward.StaticFeedforward;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.Controllable;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.SetPower;

public class Shooter extends Subsystem {
    // BOILERPLATE
    public static final Shooter INSTANCE = new Shooter();
    private Shooter() { }

    // USER CODE
    public MotorEx shootMotor1;
    public MotorEx shootMotor2;
    public MotorEx trackMotor;
    public MotorEx intakeMotor;

    ;

    public PIDFController shootSpeedController = new PIDFController(0.005, 0.0, 0.0, new StaticFeedforward(0.0));

    public String name1 = "shoot_motor_1";
    public String name2 = "shoot_motor_2";
    public String name3 = "track_motor";
    public String name4 = "intake_motor";

/*
    public Command toLow() {
        return new RunToPosition(motor, // MOTOR TO MOVE
                0.0, // TARGET POSITION, IN TICKS
                controller, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

 */

    public Command spinShooter() {
        return new SetPower(shootMotor1, 0.5, this);
    }



    @Override
    public void initialize() {
        shootMotor1 = new MotorEx(name1);
        shootMotor2 = new MotorEx(name2);
        trackMotor = new MotorEx(name3);
        intakeMotor = new MotorEx(name4);
    }
}
