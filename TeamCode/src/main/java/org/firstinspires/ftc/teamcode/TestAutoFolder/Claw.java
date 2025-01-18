package org.firstinspires.ftc.teamcode.TestAutoFolder;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.roadrunner.Action;
import com.sun.tools.javac.comp.Todo;

public class Claw {
    private Servo claw;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "Claw");
    }
    public class CloseClaw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            claw.setPosition(0.32);
            return false;
        }
    }
    public Action closeClaw() {
        return new CloseClaw();
    }

    public class OpenClaw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            claw.setPosition(0);
            return false;
        }
    }
    public Action openClaw() {
        return new OpenClaw();
    }
}
