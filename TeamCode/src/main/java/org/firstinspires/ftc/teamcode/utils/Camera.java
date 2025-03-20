package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;

/**
 * В этом классе описывается метод работы с камерой, после тестов было решено использовать энкодеры с PD регулятором.
 */

public class Camera {
    /*
    */
    private OpenCvCamera cam;
    private LinearOpMode camOpMode;
    final int rows = 480;
    final int cols = 640;

    //int cameraMonitorViewId = camOpMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", camOpMode.hardwareMap.appContext.getPackageName());
    //cam = OpenCvCameraFactory.getInstance().createWebcam(camOpMode.hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

    /*
    Camera cam = new Camera();
    cam.init(webcam, 1920, 1080)
    while(!isStarted()){
        cam.detect();
        telemetry.addData("position: ", cam.detectionTelemetry());
        telemetry.update();
    }
    if(opModeIsActive()){
        cam.detect();
        telemetry.addData("ME GO ", cam.detectionTelemetry());
        telemetry.update();
    }

}
