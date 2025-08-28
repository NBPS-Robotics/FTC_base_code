package org.firstinspires.ftc.teamcode.Opmodes.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.NextFTCOpMode;
import com.rowanmcalpin.nextftc.ftc.driving.MecanumDriverControlled;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;

import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Lift;

@TeleOp(name = "NextFTC TeleOp Program Java")
class TeleOps extends NextFTCOpMode {
    public Command driverControlled;
    public TeleOps() {
        super(Lift.INSTANCE);
    }

    // Change the motor names to suit your robot.


    @Override
    public void onInit() {

    }

    @Override
    public void onStartButtonPressed() {
        driverControlled = Drive.INSTANCE.driverControlledRobotCentric(gamepadManager);
        driverControlled.invoke();
    }
}