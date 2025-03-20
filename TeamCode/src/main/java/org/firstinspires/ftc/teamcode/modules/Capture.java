package org.firstinspires.ftc.teamcode.modules;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Этот класс описывает работу лохотрона на нашем роботе
 */

public class Capture {
    private Servo perevorot, claw;
    private LinearOpMode servoOpMode = null; //объект описывающий опмод, в котором будет использоваться наш лохотрон
    private boolean down = false, mid = false;

    /**
     * Создаем servoOpMode, как класс внутри opMod-а
     *
     * @param opMode - обычно "this", задает в каком потоке оперирует наш лохотрон
     */
    public Capture(LinearOpMode opMode) {
        servoOpMode = opMode;
    }

    /**
     * Инициализация лохотрона для opMode. Добавление в конфигурацию
     *
     */
    public void init() {
        perevorot = servoOpMode.hardwareMap.servo.get("lohotron");
        claw = servoOpMode.hardwareMap.servo.get("zahvat");

        //closeClaw();
        openClaw();
        armMid();

    }

    /**
     * Добавляем в телементрию информацию о положении ключевых механизмов
     */
    public void lohotronTelemetry() {
        servoOpMode.telemetry.addData("zahvat position: ", claw.getPosition());
        servoOpMode.telemetry.addData("zahvacheno: ", isClawClosed());
    }

    /**
     * Поднимает захват
     */
    public void armRaiser() {
        servoOpMode.sleep(150);
        perevorot.setPosition(0.18);

        servoOpMode.sleep(75);
        down = false;
        mid = false;
    }

    /**
     * Опускает захват
     */
    public void armLowerer() {
        perevorot.setPosition(0.87);
        servoOpMode.sleep(150);

        servoOpMode.sleep(75);
        down = true;
        mid = false;
    }

    /**
     * Ставим лохотрон в серединное положение
     */
    public void armMid() {
        perevorot.setPosition(0.87);

        servoOpMode.sleep(225);
        down = false;
        mid = true;
    }

    boolean armRaised = false;
    boolean armMid = false;

    /**
     * Поднимаем и опускаем лохотрон с помощью одной кнопки
     */
    public void armLogicalRaise_Lower() {
        if (!armRaised) armRaiser();
        else armLowerer();
        armRaised = !armRaised;
        armMid = false;
    }

    public void armLogicalMid_Lower() {
        if (!armMid) armMid();
        else armLowerer();
        armMid = !armMid;
        armRaised = false;
    }

    /**
     * Держать пиксель
     */
    public void closeClaw() {
        claw.setPosition(0.05);
        clawClosed = true;
        servoOpMode.sleep(150);
    }

    /**
     * Отпустить пробу
     */
    public void openClaw() {
        claw.setPosition(0.145);
        clawClosed = false;
        servoOpMode.sleep(150);
    }

    boolean clawClosed = false;

    public void logicalOpenCloseClaw() {
        if (!clawClosed) closeClaw();
        else openClaw();
    }

    /**
     * Логическая функция, которая возвращает информацию о нынешнем положении захвата
     *
     * @return
     */
    public boolean isClawClosed() {
        return clawClosed;
    }
}
