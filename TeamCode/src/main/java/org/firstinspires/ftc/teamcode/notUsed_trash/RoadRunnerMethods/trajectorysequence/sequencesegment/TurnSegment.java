package org.firstinspires.ftc.teamcode.notUsed_trash.RoadRunnerMethods.trajectorysequence.sequencesegment;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.profile.MotionProfile;
import com.acmerobotics.roadrunner.trajectory.TrajectoryMarker;
import com.acmerobotics.roadrunner.util.Angle;

import org.firstinspires.ftc.teamcode.notUsed_trash.RoadRunnerMethods.trajectorysequence.sequencesegment.SequenceSegment;

import java.util.List;

public final class TurnSegment extends SequenceSegment {
    private final double totalRotation;
    private final MotionProfile motionProfile;

    public TurnSegment(Pose2d startPose, double totalRotation, MotionProfile motionProfile, List<TrajectoryMarker> markers) {
        super(
                motionProfile.duration(),
                startPose,
                new Pose2d(
                        startPose.getX(), startPose.getY(),
                        Angle.norm(startPose.getHeading() + totalRotation)
                ),
                markers
        );

        this.totalRotation = totalRotation;
        this.motionProfile = motionProfile;
    }

    public double getTotalRotation() {
        return this.totalRotation;
    }

    public MotionProfile getMotionProfile() {
        return this.motionProfile;
    }
}
