package org.firstinspires.ftc.teamcode.architecture;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class LinearOpModeBase extends LinearOpMode {
    public abstract BaseCollector getCollector(LinearOpMode opMode);

    @Override
    public void runOpMode() {

        BaseCollector collector = getCollector(this);
        collector.init();

        waitForStart();

        collector.start();



        while (opModeIsActive()){
            collector.update();
        }
    }
}
