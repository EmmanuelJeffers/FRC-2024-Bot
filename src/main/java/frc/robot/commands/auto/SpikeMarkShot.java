// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.PivotConstants;
import frc.robot.commands.basic.RunIntake;
import frc.robot.commands.sequences.ShootingPosition;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pivot;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Trolley;
import frc.robot.subsystems.Wrist;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SpikeMarkShot extends SequentialCommandGroup {
  /** Creates a new SpikeMarkShot. */
  public SpikeMarkShot(Intake intake, Wrist wrist, Trolley trolley, Pivot pivot, Indexer indexer, Shooter shooter) {
    addCommands(
      new ShootingPosition(intake, wrist, trolley, pivot, indexer, shooter, PivotConstants.PODIUM_SETPOINT_POS).withTimeout(3),
      new RunIntake(intake, 0.75).withTimeout(0.5)
    );
  }
}
