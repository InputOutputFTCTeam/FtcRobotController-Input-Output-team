package org.firstinspires.ftc.teamcode.architecture;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpModeBase{
    @Override
    public BaseCollector getCollector(LinearOpMode opMode) {
        return new TeleOpCollector(opMode);

    }
}
