package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;

import java.util.Set;

public class PedroCommand extends Command {
    private final Set<Subsystem> subsystems;
    private final Follower follower;
    private final PathChain path;
    private final boolean interruptible = true;

    //give it drive subsystem, your path, and the path follower
    public PedroCommand(Set<Subsystem> subsystems, PathChain path, Follower follower) {
        this.subsystems = subsystems;
        this.path=path;
        this.follower=follower;
    }

    @Override//when its at the end pose it will be done
    public boolean isDone() {
        return follower.atPose(path.endPose(),1,1); // Whether or not the command is done
    }

    @Override
    public void start() {//follows the path
        follower.followPath(path);
    }
    @Override
    public void stop(boolean interrupted) {
        if(interrupted)follower.breakFollowing();
    }
}
