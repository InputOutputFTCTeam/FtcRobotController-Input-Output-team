package org.firstinspires.ftc.teamcode.modules;

import static java.lang.Double.max;
import static java.lang.Double.min;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utils.PDRegulator;

@Config
public class Lift {
    private DcMotorEx _liftAimMotor;
    private DcMotorEx _liftExtensionMotor;

    public static double AIM_K_P = 0.01;
    public static double EXTENSION_K_P = 0.01;

    public static double TRANSPORT_AIM_TARGET_POS = 150.0;
    public static double UP_BASKET_AIM_TARGET_POS = 3500.0;
    public static double CLAMP_CENTER_AIM_TARGET_POS = 150.0;

    public static double TRANSPORT_EXTENSION_TARGET_POS = 0.0;
    public static double UP_BASKET_EXTENSION_TARGET_POS = 5000.0;
    public static double CLAMP_CENTER_EXTENSION_TARGET_POS = 0.0;

    public static double CLAMP_CENTER_MAX_EXTENSION = 3000.0;

    public enum LiftPositions{
        TRANSPORT,
        UP_BASKET,
        CLAMP_CENTER
    }

    private LiftPositions _currentLiftPosition = LiftPositions.TRANSPORT;

    private ElapsedTime _deltaTime = new ElapsedTime();

    private double _extensionVelocity = 0.0;
    private double _extensionDelta = 0.0;

    public void setExtensionVelocity(double velocity){
        if(_currentLiftPosition == LiftPositions.CLAMP_CENTER)
            _extensionVelocity = velocity;
        else
            _extensionVelocity = 0.0;
    }

    public void setLiftPos(LiftPositions liftPos){
        _currentLiftPosition = liftPos;
        _extensionVelocity = 0.0;
        _extensionDelta = 0.0;
    }

    public void init(LinearOpMode linearOpMode){
        _liftAimMotor = linearOpMode.hardwareMap.get(DcMotorEx.class, "liftAimMotor");
        _liftExtensionMotor = linearOpMode.hardwareMap.get(DcMotorEx.class, "liftExtensionMotor");

        _liftAimMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        _liftAimMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        _liftAimMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        _liftAimMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        _liftExtensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        _liftExtensionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        _liftExtensionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        _liftExtensionMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void update(){
        double targetAimPos = 0.0, targetExtensionPos = 0.0;

        _extensionDelta += _extensionVelocity * _deltaTime.seconds();

        _extensionDelta = min(max(_extensionDelta, 0.0), CLAMP_CENTER_MAX_EXTENSION);

        switch (_currentLiftPosition){
            case TRANSPORT:
                targetAimPos = TRANSPORT_AIM_TARGET_POS;
                targetExtensionPos = TRANSPORT_EXTENSION_TARGET_POS;
                break;

            case UP_BASKET:
                targetAimPos = UP_BASKET_AIM_TARGET_POS;
                targetExtensionPos = UP_BASKET_EXTENSION_TARGET_POS;
                break;

            case CLAMP_CENTER:
                targetAimPos = CLAMP_CENTER_AIM_TARGET_POS;
                targetExtensionPos = CLAMP_CENTER_EXTENSION_TARGET_POS + _extensionDelta;
                break;
        }

        _liftAimMotor.setPower((targetAimPos - _liftAimMotor.getCurrentPosition()) * AIM_K_P);
        _liftExtensionMotor.setPower((targetExtensionPos - _liftExtensionMotor.getCurrentPosition()) * EXTENSION_K_P);

        _deltaTime.reset();
    }

    public void start(){
        _deltaTime.reset();
    }
}
