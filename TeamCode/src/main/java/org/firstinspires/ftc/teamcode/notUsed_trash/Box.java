package org.firstinspires.ftc.teamcode.notUsed_trash;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
public class Box {
    private Servo servoBox;
    private final LinearOpMode boxOpMode;
    private boolean inited = false;

    public Box(LinearOpMode opMode){
        boxOpMode = opMode;
    }

    public void initBox(){
        servoBox = boxOpMode.hardwareMap.servo.get("servobox");
        inited = true;
    }

    public void telemetryBox(){
        boxOpMode.telemetry.addData("box position: ", servoBox.getPosition());
    }

    public void upp(){
        servoBox.setPosition(0);
    }
    public void down(){
        servoBox.setPosition(0.75);
    }
    public void mid(){
        servoBox.setPosition(0.5);
    }
}
