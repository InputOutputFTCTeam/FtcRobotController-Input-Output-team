package org.firstinspires.ftc.teamcode.notUsed_trash.Basic;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * В этом классе описывается модуль крюков, которыми робот цепляется за перекладину
 */
@Disabled
public class Hook {
    private Servo leftHook1, rightHook1;
    private Servo leftHook2, rightHook2;
    private final boolean inited = true;
    private boolean hooked = false;
    private final LinearOpMode hookOpMode;

    /**
     * Создаем крюки, как класс внутри opMod-а
     * @param opMode - обычно "this", задает в каком потоке оперируют наши крюки
     * @param opMode
     */
    public Hook(LinearOpMode opMode){
        hookOpMode = opMode;
    }

    /**
     * Инициализация крюков для opMode. Добавление в конфигурацию
     */
    public void initHooks(){
        leftHook1 = hookOpMode.hardwareMap.servo.get("leftHook1");
        leftHook2 = hookOpMode.hardwareMap.servo.get("leftHook2");
        rightHook1 = hookOpMode.hardwareMap.servo.get("rightHook1");
        rightHook2 = hookOpMode.hardwareMap.servo.get("rightHook2");

        hookOpMode.telemetry.addLine("Hook ready!");
    }

    /**
     * Добавляем информацию в телеметрию о состоянии крюков
     */
    public void telemetryHooks(){
        hookOpMode.telemetry.addData("hooks state: ", hooked);
    }

    /**
     * Поднимаем крюки
     */
    public void openHook(){
        leftHook1.setPosition(0.04);
        rightHook1.setPosition(0.945);

        hookOpMode.sleep(250);

        leftHook2.setPosition(0);
        rightHook2.setPosition(1);

        hookOpMode.sleep(50);
    }

    /**
     * Складываем крюки
     */
    public void closeHook(){
        leftHook2.setPosition(1);
        rightHook2.setPosition(0.01);

        hookOpMode.sleep(500);

        leftHook1.setPosition(0.59);
        rightHook1.setPosition(0.4);

        hookOpMode.sleep(50);
    }

    public void midHook(){
        leftHook1.setPosition(0.46);
        rightHook1.setPosition(0.57);
        hookOpMode.sleep(100);
    }

    /**
     * Переключение положения крюков
     */
    public void switchHook(){
        if(hooked) openHook(); else closeHook();
        hooked = !hooked;
    }

}
