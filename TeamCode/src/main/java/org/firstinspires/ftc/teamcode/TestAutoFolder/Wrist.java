package org.firstinspires.ftc.teamcode.TestAutoFolder;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private Servo wrist;

    public Wrist(HardwareMap hardwareMap) {
        wrist = hardwareMap.get(Servo.class, "wrist");

    }

    //This one moves the wrist to it's middle postition level with the floor ( probably should have arm at WallGrab() or Floorgrab() )
    public class Wristout implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wrist.setPosition(0.64);
            return false;
        }


    }

    public Action Wristout() {
        return new Wrist.Wristout();
    }

    //This one points the claw down (Use with Armdown() and Armup()
    public class Wristdown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wrist.setPosition(0);
            return false;
        }


    }

    public Action Wristdown() {
        return new Wrist.Wristdown();
    }
    //This one sets the wrist to the up position. This is for putting them on the bar when you grab them from the wall.
    public class Wristup implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wrist.setPosition(1);
            return false;
        }


    }

    public Action Wristup() {
        return new Wrist.Wristup();
    }
    public class Wristbgrab implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wrist.setPosition(0.64);
            return false;
        }


    }

    public Action Wristbgrab() {
        return new Wrist.Wristbgrab();
    }
}

