package org.firstinspires.ftc.teamcode.TestAutoFolder;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TestAutoFolder.Arm;
import org.firstinspires.ftc.teamcode.TestAutoFolder.Claw;
import org.firstinspires.ftc.teamcode.TestAutoFolder.Lift;
@Autonomous(name = "ActionTester")
public class ActionTester extends LinearOpMode {
    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(0, -63.25, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        Claw claw = new Claw(hardwareMap);
        Lift Lift = new Lift(hardwareMap);
        Wrist wrist = new Wrist(hardwareMap);
        Arm Arm = new Arm(hardwareMap);
        Actions.runBlocking(new ParallelAction(
                claw.closeClaw(),
                Arm.armclip(),
                wrist.Wristdown()
        ));
        waitForStart();
        Actions.runBlocking(new ParallelAction(
                Lift.liftUp1()
        ));
        Actions.runBlocking(
        new SleepAction(3)
        );
    }

}
