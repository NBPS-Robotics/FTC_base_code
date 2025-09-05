package org.firstinspires.ftc.teamcode.Opmodes.Autos;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.groups.ParallelGroup;
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup;
import com.rowanmcalpin.nextftc.core.command.utility.delays.Delay;
import com.rowanmcalpin.nextftc.ftc.NextFTCOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Lift;
import org.firstinspires.ftc.teamcode.pedroPathing.PedroCommand;

import java.util.Set;

@Autonomous(name = "NextFTC Autonomous Program Java")
public class SampleAuto extends NextFTCOpMode {
    public SampleAuto() {
        super(Lift.INSTANCE);
    }

    Follower follower;

    private final Pose startPose = new Pose(9.0, 60.0, Math.toRadians(0.0));
    private final Pose finishPose = new Pose(37.0, 50.0, Math.toRadians(180.0));

    private PathChain path1 = follower.pathBuilder()
            .addPath(new BezierLine(startPose, finishPose))
            .setLinearHeadingInterpolation(startPose.getHeading(), finishPose.getHeading())
            .build();

    public Command firstRoutine() {
        return new SequentialGroup(
                Lift.INSTANCE.toHigh(),
                new ParallelGroup(
                        Lift.INSTANCE.toMiddle(),
                        new PedroCommand(Set.of(Lift.INSTANCE), path1, follower)
                ),
                new Delay(0.5),
                new ParallelGroup(
                        Lift.INSTANCE.toLow()
                )
        );
    }

    @Override
    public void onStartButtonPressed() {
        firstRoutine().invoke();
    }
}
