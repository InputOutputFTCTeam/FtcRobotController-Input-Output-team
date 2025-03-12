package org.firstinspires.ftc.teamcode.ACTIVE_CODE.BasicModules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
public class SlidingRails {
    private DcMotor EL, EX;
    private LinearOpMode SlidingRails = null;
    private boolean Initialized = false, Encoded = false;

    /**
     * Создаем колесную базу, как класс внутри opMod-а
     */
    public SlidingRails() {
    }

    /**
     * Создаем колесную базу, как класс внутри opMod-а
     *
     * @param opMode - обычно "this", задает в каком потоке оперирует наша кб
     */
    public SlidingRails(LinearOpMode opMode) {
        SlidingRails = opMode;
    }

    public LinearOpMode getOpMode() {
        return SlidingRails;
    }

    public void setOpMode(LinearOpMode opMode) {
        SlidingRails = opMode;
    }

    /**
     * Инициализация кб для opMode. Добавление в конфигурацию
     */
    public void initedSlidingRails() {
        EL = SlidingRails.hardwareMap.dcMotor.get("elevatorLifting");
        EX = SlidingRails.hardwareMap.dcMotor.get("elevatorExtension");
        Initialized = true;

        SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ ИНИЦИАЛИЗИРОВАНЫ!");
    }

    /**
     * [энкодеры] моторы можно запустить в режиме run_to_position или run_using_encoder или run_without_encoder
     */
    public void setModesRails(DcMotor.RunMode mode) {
        if (Initialized) {
            EL.setMode(mode);
            EX.setMode(mode);
            if (mode == DcMotor.RunMode.RUN_USING_ENCODER || mode == DcMotor.RunMode.RUN_TO_POSITION)
                Encoded = true;
        } else {
            SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ НЕ ИНИЦИАЛИЗИРОВАНЫ");
            SlidingRails.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            SlidingRails.telemetry.update();
        }
    }
    /**
     * [энкодеры] новая целевая позиция для мотора
     */
    public void setTargetsRails(int[] newTarget){
        if(Initialized){
            EL.setTargetPosition(newTarget[0]);     //possibly can cause errors! tests recommended
            EX.setTargetPosition(newTarget[1]);
        } else {
            SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ НЕ ИНИЦИАЛИЗИРОВАНЫ");
            SlidingRails.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            SlidingRails.telemetry.update();
        }
    }
    /**
     * устанавливает направление вращения моторов
     * @param dir FORWARD или REVERSE
     */
    public void setOneDirectionRails(DcMotorSimple.Direction dir){
        if(Initialized){
            EL.setDirection(dir);
            EX.setDirection(dir);
        } else {
            SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ НЕ ИНИЦИАЛИЗИРОВАНЫ");
            SlidingRails.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            SlidingRails.telemetry.update();
        }
    }
    /**
     * задает режим остановки всем 4м моторам
     */
    public void setZeroPowerBehaviorsRails(DcMotor.ZeroPowerBehavior behavior) {
        if (Initialized) {
            EL.setZeroPowerBehavior(behavior);
            EX.setZeroPowerBehavior(behavior);
        } else {
            SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ НЕ ИНИЦИАЛИЗИРОВАНЫ");
            SlidingRails.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            SlidingRails.telemetry.update();
        }
    }
    /**
     * движение направляющих робота
     * @param z меньше 0 - ехать назад, больше 0 - ехать вперед
     */
    public void Lifting(double z){
        if(Initialized){
            EL.setPower(z);
        } else {
            SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ НЕ ИНИЦИАЛИЗИРОВАНЫ");
            SlidingRails.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            SlidingRails.telemetry.update();
        }
    }

    /**
     *
     * @param w движение вокруг своей оси. больше 0 - разворот по часовой, меньше 0 - разворот против часовой
     */
    public void Extension(double w){
        if(Initialized){
            EL.setPower(w);
        } else {
            SlidingRails.telemetry.addLine("ВЫДВИЖНЫЕ НАПРАВЛЯЮЩИЕ НЕ ИНИЦИАЛИЗИРОВАНЫ");
            SlidingRails.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            SlidingRails.telemetry.update();
        }
    }
}
