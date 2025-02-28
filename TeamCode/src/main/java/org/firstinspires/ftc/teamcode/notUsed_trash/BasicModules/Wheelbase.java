package org.firstinspires.ftc.teamcode.notUsed_trash.BasicModules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

public class Wheelbase {
    private DcMotor TL, TR, BL, BR;
    private LinearOpMode Wheelbase = null;
    private boolean Initialized = false, Encoded = false;
    double maximumSpeed = 1;

    /**
     * Создаем колесную базу, как класс внутри opMod-а
     */
    public Wheelbase() {
    }

    /**
     * Создаем колесную базу, как класс внутри opMod-а
     *
     * @param opMode - обычно "this", задает в каком потоке оперирует наша кб
     */
    public Wheelbase(LinearOpMode opMode) {
        Wheelbase = opMode;
    }

    public LinearOpMode getOpMode() {
        return Wheelbase;
    }

    public void setOpMode(LinearOpMode opMode) {
        Wheelbase = opMode;
    }

    /**
     * Инициализация кб для opMode. Добавление в конфигурацию
     */
    public void initedWheelbase() {
        TL = Wheelbase.hardwareMap.dcMotor.get("leftFront");
        TR = Wheelbase.hardwareMap.dcMotor.get("rightFront");
        BL = Wheelbase.hardwareMap.dcMotor.get("leftRear");
        BR = Wheelbase.hardwareMap.dcMotor.get("rightRear");
        Initialized = true;

        Wheelbase.telemetry.addLine("КОЛЕСНАЯ БАЗА ИНИЦИАЛИЗИРОВАНА!");
    }

    /**
     * [энкодеры] моторы можно запустить в режиме run_to_position или run_using_encoder или run_without_encoder
     */
    public void setModesWheel(DcMotor.RunMode mode) {
        if (Initialized) {
            TL.setMode(mode);
            TR.setMode(mode);
            BL.setMode(mode);
            BR.setMode(mode);
            if (mode == DcMotor.RunMode.RUN_USING_ENCODER || mode == DcMotor.RunMode.RUN_TO_POSITION)
                Encoded = true;
        } else {
            Wheelbase.telemetry.addLine("КОЛЕСНАЯ БАЗА НЕ ИНИЦИАЛИЗИРОВАНА");
            Wheelbase.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            Wheelbase.telemetry.update();
        }
    }
    /**
     * [энкодеры] новая целевая позиция для мотора
     */
    public void setTargetsWheel(int[] newTarget){
        if(Initialized){
            TL.setTargetPosition(newTarget[0]);     //possibly can cause errors! tests recommended
            TR.setTargetPosition(newTarget[1]);
            BL.setTargetPosition(newTarget[2]);
            BR.setTargetPosition(newTarget[3]);
        } else {
            Wheelbase.telemetry.addLine("КОЛЕСНАЯ БАЗА НЕ ИНИЦИАЛИЗИРОВАНА");
            Wheelbase.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            Wheelbase.telemetry.update();
        }
    }
    /**
     * устанавливает направление вращения моторов
     * @param dir FORWARD или REVERSE
     */
    public void setOneDirectionWheel(DcMotorSimple.Direction dir){
        if(Initialized){
            TL.setDirection(dir);
            TR.setDirection(dir);
            BL.setDirection(dir);
            BR.setDirection(dir);
        } else {
            Wheelbase.telemetry.addLine("КОЛЕСНАЯ БАЗА НЕ ИНИЦИАЛИЗИРОВАНА");
            Wheelbase.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            Wheelbase.telemetry.update();
        }
    }
    /**
     * задает режим остановки всем 4м моторам
     */
    public void setZeroPowerBehaviorsWheel(DcMotor.ZeroPowerBehavior behavior) {
        if (Initialized) {
            TL.setZeroPowerBehavior(behavior);
            TR.setZeroPowerBehavior(behavior);
            BL.setZeroPowerBehavior(behavior);
            BR.setZeroPowerBehavior(behavior);
        } else {
            Wheelbase.telemetry.addLine("КОЛЕСНАЯ БАЗА НЕ ИНИЦИАЛИЗИРОВАНА");
            Wheelbase.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            Wheelbase.telemetry.update();
        }
    }
    /**
     * движение колесной базы робота
     * @param x меньше 0 - ехать назад, больше 0 - ехать вперед
     * @param y движение вокруг своей оси. больше 0 - разворот по часовой, меньше 0 - разворот против часовой
     * @param strafe  меньше 0 - ехать влево, больше 0 - ехать вправо
     */
    public void move(double x, double y, double strafe){
        if(Initialized){
            TL.setPower(Range.clip((x - y + strafe), -maximumSpeed, maximumSpeed));
            TR.setPower(Range.clip((x + y + strafe), -maximumSpeed, maximumSpeed));
            BL.setPower(Range.clip((x + y + strafe), -maximumSpeed, maximumSpeed));
            BR.setPower(Range.clip((x - y + strafe), -maximumSpeed, maximumSpeed));
        } else {
            Wheelbase.telemetry.addLine("КОЛЕСНАЯ БАЗА НЕ ИНИЦИАЛИЗИРОВАНА");
            Wheelbase.telemetry.addLine("НЕОБХОДИМО ПОЧИНИТЬ КОД!");
            Wheelbase.telemetry.update();
        }
    }
}