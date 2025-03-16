package org.firstinspires.ftc.teamcode.architecture;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.modules.Lift;

public class BaseCollector {
    public Lift Lift;

    private LinearOpMode _linearOpMode;

    public BaseCollector(LinearOpMode opMode){
        Lift = new Lift();

        _linearOpMode = opMode;
    }

    public void init(){
        Lift.init(_linearOpMode);
    }

    public void start(){
        Lift.start();
    }

    public void update(){
        Lift.update();
    }
}
