package org.usfirst.frc.team6217.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//this a comment
public class Robot extends IterativeRobot {
	private SpeedControllerGroup m_robotDrive_Leftside
		= new SpeedControllerGroup(new VictorSP(6), new VictorSP(7));

	private SpeedControllerGroup m_robotDrive_Rightside
		= new SpeedControllerGroup(new VictorSP(8), new VictorSP(9));

	private DifferentialDrive m_robotDrive
		= new DifferentialDrive(m_robotDrive_Rightside, m_robotDrive_Leftside);

	
	private Timer m_timer = new Timer();

	@Override
	public void robotInit() {
		
	}

	@Override
	public void autonomousInit() {
		m_timer.reset();
		m_timer.start();
	}

	@Override
	public void autonomousPeriodic() {
		if (m_timer.get() < 7.0) {
			m_robotDrive.arcadeDrive(-0.5, 0, true);
		}
		
		else {
			m_robotDrive.stopMotor();
		}
	
	}
	
	@Override
	public void teleopPeriodic() {
	}

	@Override
	public void testPeriodic() {
	}
}
