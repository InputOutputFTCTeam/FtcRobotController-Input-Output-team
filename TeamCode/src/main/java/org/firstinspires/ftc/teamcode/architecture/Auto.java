package org.firstinspires.ftc.teamcode.architecture;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class Auto extends LinearOpModeBase{
    @Override
    public BaseCollector getCollector(LinearOpMode opMode) {
        return new AutoCollector(opMode);
    }
}
