package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.architecture.TeleOpCollector;

@Config
public class Gamepad {
    public static double EXTENSION_SENS = 200000.0;

    private com.qualcomm.robotcore.hardware.Gamepad _gamepad;
    private Lift _lift;

    public void init(LinearOpMode linearOpMode, TeleOpCollector collector){
        _gamepad = linearOpMode.gamepad1;
        _lift = collector.Lift;

    }

    public void start(){

    }

    private boolean _transportLiftPosOld = false;
    private boolean _upBasketLiftPosOld = false;
    private boolean _clampCenterLiftPosOld = false;

    public void update(){
        if(!_transportLiftPosOld && _gamepad.dpad_left)
            _lift.setLiftPos(Lift.LiftPositions.TRANSPORT);

        if(!_upBasketLiftPosOld && _gamepad.dpad_up)
            _lift.setLiftPos(Lift.LiftPositions.UP_BASKET);

        if(!_clampCenterLiftPosOld && _gamepad.dpad_down)
            _lift.setLiftPos(Lift.LiftPositions.CLAMP_CENTER);

        _transportLiftPosOld = _gamepad.dpad_left;
        _upBasketLiftPosOld = _gamepad.dpad_up;
        _clampCenterLiftPosOld = _gamepad.dpad_down;

        _lift.setExtensionVelocity((_gamepad.left_trigger - _gamepad.right_trigger) * EXTENSION_SENS);
    }
}
