package com.ma.bears.Kickback.subsystems;

import com.ma.bears.Victor884;
import com.ma.bears.Kickback.Ports;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive subsystem.
 * Includes all parts of the robot uses to drive.
 * 
 * @author Brett Levenson
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class Drive extends Subsystem{
	
	private Victor884 leftDrive = new Victor884(Ports.PWM_Left_Drive);
	private Victor884 rightDrive = new Victor884(Ports.PWM_Right_Drive);
        
	//encoders don't actually exist currently
    
    private DoubleSolenoid Shifter = new DoubleSolenoid(Ports.Sol_Shifter1, Ports.Sol_Shifter2);
    
	protected void initDefaultCommand() {
	}
	
	public void drive(double speed){
		setLeftSpeed(speed);
		setRightSpeed(speed);
	}
	public void setLeftSpeed(double speed){
		leftDrive.set(speed);
	}
	public void setRightSpeed(double speed){
		rightDrive.set(speed);
	}
	public void setShifter(boolean highGear){
		//Shifter.set(!highGear);
		Shifter.set(highGear? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
	}
	
    public float translateDrive(float trans){
		double wheel_d = 0.0899;
		double counts = 256 * 4.0;
		return (float) ((trans / counts) * (Math.PI) * wheel_d);
	}

}
