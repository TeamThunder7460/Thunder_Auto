package org.firstinspires.ftc.teamcode.TestAutoFolder;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;


public class Lift {
    public DcMotorEx liftR = null;
    public DcMotorEx liftL = null;

    public Lift(HardwareMap hardwareMap) {
        liftR = hardwareMap.get(DcMotorEx.class, "rl");
        liftR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftR.setDirection(DcMotorSimple.Direction.FORWARD);
        liftL = hardwareMap.get(DcMotorEx.class, "ll");
        liftL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftL.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public class LiftUp1 implements Action {
        // Puts to chamber height
        // checks if the lift motor has been powered on

        private boolean initialized = false;

        // actions are formatted via telemetry packets as below
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //#TODO: actually make this work with PID
            // powers on motor, if it is not on
            if (!initialized) {
                liftR.setVelocity(1658);
                liftL.setVelocity(1658);
                initialized = true;
            }

            // checks lift's current position
            double pos = liftR.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos < 1000) {
                // true causes the action to rerun
                return true;
            } else {
                // false stops action rerun
                liftR.setVelocity(1);
                liftL.setVelocity(1);
                return false;
            }
            // overall, the action powers the lift until it surpasses
            // 1258 encoder ticks, then powers it off
        }
    }
    public Action liftUp1() {
        return new LiftUp1();
    }
    public class LiftUp2 implements Action {
        // Puts to basket height
        // checks if the lift motor has been powered on

        private boolean initialized = false;

        // actions are formatted via telemetry packets as below
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //#TODO: actually make this work with PID
            // powers on motor, if it is not on
            if (!initialized) {
                liftR.setVelocity(1658);
                liftL.setVelocity(1658);
                initialized = true;
            }

            // checks lift's current position
            double pos = liftR.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos < 3000) {
                // true causes the action to rerun

                return true;
            } else {
                // false stops action rerun
                liftR.setVelocity(1);
                liftL.setVelocity(1);
                return false;
            }
            // overall, the action powers the lift until it surpasses
            // 3000 encoder ticks, then powers it off
        }
    }
    public Action liftUp2() {
        return new LiftUp2();
    }
//Liftdown below \/
    public class LiftDown implements Action {
    // checks if the lift motor has been powered on

        private boolean initialized = false;

        // actions are formatted via telemetry packets as below
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //#TODO: actually make this work with PID
            // powers on motor, if it is not on
            if (!initialized) {
                liftR.setVelocity(-1638);
                liftL.setVelocity(-1638);
                initialized = true;
            }

            // checks lift's current position
            double pos = liftR.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos > 10) {
                // true causes the action to rerun
                return true;
            } else {
                // false stops action rerun
                liftR.setVelocity(0);
                liftL.setVelocity(0);
                return false;
            }
            // overall, the action powers the lift until it decreases below
            // 10 encoder ticks, then powers it off
    }
}
    public Action liftDown() {
        return new LiftDown();
    }

}
