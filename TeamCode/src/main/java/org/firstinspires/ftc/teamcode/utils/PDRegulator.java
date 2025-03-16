package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PDRegulator {
    public double kp = 0.0;
    public double kd = 0.0;
    public double maxPower = 1.0;

    public PDRegulator(double p, double d, double maxPower){
        kp = p;
        kd = d;
        this.maxPower = maxPower;
    }

    public void start(){
        _deltaTime.reset();
    }

    private ElapsedTime _deltaTime = new ElapsedTime();

    private double _oldErr = 0.0;

    public double update(double err){
        double up = err * kp;
        double ud = (err - _oldErr) / _deltaTime.seconds() * kd;

        _oldErr = err;

        _deltaTime.reset();

        return up + ud;
    }
}
