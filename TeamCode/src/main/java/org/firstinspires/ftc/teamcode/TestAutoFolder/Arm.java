package org.firstinspires.ftc.teamcode.TestAutoFolder;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private Servo armL;
    private Servo armR;

    public Arm(HardwareMap hardwareMap) {
        armL = hardwareMap.get(Servo.class, "LA");
        armR = hardwareMap.get(Servo.class, "RA");
    }

    //Sets arm to all the way upwards position
    public class armup implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            armL.setPosition(0.42);
            armR.setPosition(0.22);
            return false;
        }
    }
    public Action armup() {
        return new Arm.armup();
    }

    public class armdown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            armL.setPosition(0.04);
            armR.setPosition(0.60);
            return false;
        }
    }
    public Action armdown() {
        return new Arm.armdown();
    }

    public class armfloor implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            armL.setPosition(0.0);
            armR.setPosition(0.64);
            return false;
        }
    }
    public Action armfloor() {
        return new Arm.armfloor();
    }

    public class armwall implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            armR.setPosition(0);
            armL.setPosition(0.64);
            return false;
        }
    }
    public Action armwall() {
        return new Arm.armwall();
    }

    public class armclip implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            armR.setPosition(0.1973);
            armL.setPosition(0.4426);
            return false;
        }
    }
    public Action armclip() {
        return new Arm.armclip();
    }

}