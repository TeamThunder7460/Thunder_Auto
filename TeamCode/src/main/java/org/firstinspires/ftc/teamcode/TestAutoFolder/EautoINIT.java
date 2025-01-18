package org.firstinspires.ftc.teamcode.TestAutoFolder;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TestAutoFolder.Arm;
import org.firstinspires.ftc.teamcode.TestAutoFolder.Claw;
import org.firstinspires.ftc.teamcode.TestAutoFolder.Lift;

@Autonomous(name = "TesticleRR")
public class EautoINIT extends LinearOpMode {
    @Override
    public void runOpMode() {
        //Start position for RED
        Pose2d initialPose = new Pose2d(0, -63.25, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        Claw claw = new Claw(hardwareMap);
        Lift lift = new Lift(hardwareMap);
        Wrist wrist = new Wrist(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        resetRuntime();
        Actions.runBlocking(new SequentialAction(
            claw.closeClaw()
        ));
        TrajectoryActionBuilder fw1 = drive.actionBuilder(initialPose)
                .setTangent(Math.toRadians(90))
                .lineToY(-32.25);
        TrajectoryActionBuilder fw2 =  fw1.endTrajectory().fresh()
                .setTangent(Math.toRadians(90))
                .lineToY(-40)
                .splineToConstantHeading(new Vector2d(49.25,-53), Math.toRadians(90));
        TrajectoryActionBuilder fw3 =  fw2.endTrajectory().fresh()
                .setTangent(Math.toRadians(90))
                .lineToY( -50, new TranslationalVelConstraint(4.0));
        TrajectoryActionBuilder fw6 =  fw3.endTrajectory().fresh()
                .setTangent(Math.toRadians(90))
                .lineToY( -60);
        TrajectoryActionBuilder fw7 =  fw6.endTrajectory().fresh()
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(5,-53), Math.toRadians(90))
                .lineToY( -30.25);
        TrajectoryActionBuilder fw8 =  fw7.endTrajectory().fresh()
                .setTangent(Math.toRadians(90))
                .lineToY( -40)
                .splineToConstantHeading(new Vector2d(23.29, -45.41), Math.toRadians(-48.93))
                .splineToConstantHeading(new Vector2d(40.00, -60.50), Math.toRadians(270.00));

        TrajectoryActionBuilder fw9 =  fw8.endTrajectory().fresh()
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-8,-53), Math.toRadians(90))
                .lineToY( -30.25);




        Action TrajectoryClose = fw1.endTrajectory().build();


        if (isStopRequested()) return;
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        Action fwgo1;
            fwgo1 = fw1.build();
        Action fwgo2;
            fwgo2 = fw2.build();
        Action fwgo3;
            fwgo3 = fw3.build();
//        Action fwgo4;
//            fwgo4 = fw4.build();
//        Action fwgo5;
//            fwgo5 = fw5.build();
        Action fwgo6;
        fwgo6 = fw6.build();
        Action fwgo7;
        fwgo7 = fw7.build();
        Action fwgo8;
        fwgo8 = fw8.build();
        Action fwgo9;
        fwgo9 = fw9.build();
        Actions.runBlocking(
                new SequentialAction(
                        new ParallelAction(
                                fwgo1,
                                wrist.Wristdown(),
                                arm.armclip()
                        ),
                        new SleepAction(0.1),
                        new SequentialAction(
                                lift.liftUp1()
                        ),
                        new SleepAction(0.1),
                        new SequentialAction(
                                claw.openClaw(),
                                arm.armup(),
                                wrist.Wristbgrab(),
                                lift.liftDown()
                        ),
                        new SleepAction(0.1),
                        new SequentialAction(
                                fwgo2,
                                arm.armfloor()
                        ),
                        new SleepAction(0.8),
                        new SequentialAction(
                                fwgo3
                        ),
                        new SequentialAction(
                                claw.closeClaw()
                        ),
                        new SleepAction(0.3),
                        new SequentialAction(
                                arm.armwall()
                        ),
                        new SleepAction(0.95),
                        new SequentialAction(
                                claw.openClaw()
                        ),
                        new SleepAction(0.5),
                        //scndblock
                        new SequentialAction(
                                claw.openClaw(),
                                wrist.Wristbgrab()
                        ),
                        new SleepAction(0.1),
                        new SequentialAction(
                                fwgo6,
                                claw.closeClaw()
                        ),
                        new SleepAction(0.3),
                        new ParallelAction(
                                lift.liftUp1()
                        ),
                        new SleepAction(0.25),
                        new ParallelAction(
                                lift.liftDown(),
                                fwgo7,
                                arm.armclip(),
                                wrist.Wristdown()
                        ),
                        new SleepAction(0.5),
                        new ParallelAction(
                                lift.liftUp1()
                        ),
                        new SequentialAction(
                                claw.openClaw(),
                                arm.armup(),
                                wrist.Wristbgrab(),
                                lift.liftDown()
                        ),
                        //trdhook
                        new SequentialAction(
                                arm.armwall(),
                                fwgo8
                        ),
                        new SleepAction(0.5),
                                new SequentialAction(
                                claw.closeClaw()
                        ),
                        new SleepAction(0.3),
                        new ParallelAction(
                                lift.liftUp1()
                        ),
                        new ParallelAction(
                                lift.liftDown(),
                                fwgo9,
                                arm.armclip(),
                                wrist.Wristdown()
                        ),
                        new SleepAction(0.5),
                        new ParallelAction(
                                lift.liftUp1()
                        ),
                        new SequentialAction(
                                claw.openClaw(),
                                arm.armup(),
                                wrist.Wristbgrab(),
                                lift.liftDown()
                        )


                )
        );
    }
}