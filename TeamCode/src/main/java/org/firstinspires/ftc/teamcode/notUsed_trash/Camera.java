package org.firstinspires.ftc.teamcode.notUsed_trash;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;

/**
 * В этом классе описывается метод работы с камерой для распознования командного реквизита.
 * По правилам сезона Centerstage реквизит распологается на одной из трех позиций относительно робота.
 * Чтобы выполнить задание рандомизации в автономном периоде используется камера и она передает данные
 * куда надо проехать и положить желтый пиксель.
 */

public class Camera {
    /*
    TODO:   создать объект камеры
            описать метод просмотра информации с камеры
            описать области сканирования
            описать метод получения данных с камеры
    */
    private OpenCvCamera cam;
    private LinearOpMode camOpMode;
    final int rows = 480;
    final int cols = 640;

    int cameraMonitorViewId = camOpMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", camOpMode.hardwareMap.appContext.getPackageName());
    //cam = OpenCvCameraFactory.getInstance().createWebcam(camOpMode.hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

    /*
    на практике должно выглядеть, как:
    Camera cam = new Camera();
    cam.init(webcam, 1920, 1080)
    (в ран оп моде)
    while(!isStarted()){
        cam.detect();
        telemetry.addData("position: ", cam.detectionTelemetry());
        telemetry.update();
    }
    if(opModeIsActive()){
        cam.detect();
        telemetry.addData("ME GO ", cam.detectionTelemetry());
        telemetry.update();
        //езда, сброс и т.д.
    }
     */

}
