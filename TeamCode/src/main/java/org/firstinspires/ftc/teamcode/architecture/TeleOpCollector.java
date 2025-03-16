package org.firstinspires.ftc.teamcode.architecture;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.Gamepad;

public class TeleOpCollector extends BaseCollector{
    public Gamepad Gamepad;

    private LinearOpMode _linearOpMode;

    public TeleOpCollector(LinearOpMode opMode) {
        super(opMode);

        _linearOpMode = opMode;

        Gamepad = new Gamepad();
    }

    @Override
    public void update() {
        super.update();

        Gamepad.update();
    }

    @Override
    public void start() {
        super.start();

        Gamepad.start();
    }

    @Override
    public void init() {
        super.init();

        Gamepad.init(_linearOpMode, this);
    }
}
