package org.firstinspires.ftc.teamcode.notUsed_trash.BasicModules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
public class SampleCapture {
    private LinearOpMode backOpMode;
    private boolean Grabbed = false, Initialized = false;
    private Servo CAPTURE, HAND;

    /**
     * Создаем задний захват, как класс внутри opMod-а
     * @param opMode обычно "this", задает в каком потоке оперирует наш з-захват
     */

    public SampleCapture(LinearOpMode opMode){
        backOpMode = opMode;
    }

    /**
     * Инициализация 2-захватов для opMode. Добавление в конфигурацию
     */
    public void InitializedSampleCapture(){
        CAPTURE = backOpMode.hardwareMap.servo.get("sampleCapture");
        HAND = backOpMode.hardwareMap.servo.get("excitingHand");
        Initialized = true;
    }
    /**
     * Захватить захват завхатывать захват вооруженный одной сервой
     */
    public void grab(){
        CAPTURE.setPosition(1);
        Grabbed = true;
    }

    public void ungrab(){
        CAPTURE.setPosition(0.85);
        Grabbed = false;
    }

    public void handpos(double pos){
        CAPTURE.setPosition(pos);
    }
}
