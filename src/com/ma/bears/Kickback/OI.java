package com.ma.bears.Kickback;

import com.ma.bears.Kickback.CheesyVisionServer;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Operator interface class.
 * 
 * <p>All OI-related things should be declared here,
 * except for things that can be called statically
 * system-wide, like DriverStationLCD and SmartDashboard.
 * Declared here they can be accessed throughout the whole code
 * through CommandBase.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class OI {
	public Joystick
    jLeft = new Joystick(1),
    jRight = new Joystick(2),
    jBox = new Joystick(3),
    jGpad = new Joystick(4);
    
    public Button      
    buttonShifter = new JoystickButton(jLeft, Buttons.Shifter),
    buttonQuickTurn = new JoystickButton(jRight, Buttons.QuickTurn),
    buttonReverse = new JoystickButton(jRight, Buttons.Reverse),
    buttonAutonSwitch = new JoystickButton(jBox, Buttons.AutonSwitch),
    
    //gamepad buttons
    GPbuttonShifter = new JoystickButton(jGpad, Buttons.GPShifter),
    GPbuttonQuickTurn = new JoystickButton(jGpad, Buttons.GPQuickTurn),
    GPbuttonReverse = new JoystickButton(jGpad, Buttons.GPReverse),
    GPbuttonShoot = new JoystickButton(jGpad, Buttons.GPShoot),
    GPbuttonAuton = new JoystickButton(jGpad, Buttons.GPAuton);
    
    public CheesyVisionServer server = CheesyVisionServer.getInstance();
    
    //Auton Stuff
    public int AutonMode = 0;
    
    public boolean TankDrive = false;
    public boolean UseGamepad = false;
    
	public OI(){
	}
	
	//interface for gamepad support
	//we can map commands to multiple buttons, but not for drive inputs
	public boolean getShifter(){
		return !UseGamepad? buttonShifter.get() : GPbuttonShifter.get();
	}
	public boolean getQuickTurn(){
		return !UseGamepad? buttonQuickTurn.get() : GPbuttonQuickTurn.get();
	}
	public boolean getReverse(){
		return !UseGamepad? buttonReverse.get() : GPbuttonReverse.get();
	}
	
	//cheesydrive here
	public double getThrottle(){
		return !UseGamepad? jLeft.getY() : jGpad.getRawAxis(2);
	}
	public double getSteer(){
		return !UseGamepad? jRight.getX() : jGpad.getRawAxis(3);
	}
	//tank drive here
	public double getLeft(){
		return !UseGamepad? jLeft.getRawAxis(2) : jGpad.getRawAxis(2);
	}
	public double getRight(){
		return !UseGamepad? jRight.getRawAxis(2) : jGpad.getRawAxis(4);
	}
	public void setTankDrive(boolean in){
		TankDrive = in;
	}
	public boolean getTankDrive(){
		return TankDrive;
	}
	public void setUseGamepad(boolean in){
		UseGamepad = in;
	}
	public boolean getUseGamepad(){
		return UseGamepad;
	}
	
	public void incrementAutonMode(){
		AutonMode++;
        
        if (AutonMode > RobotValues.Auton_Max){
            AutonMode = -1;
        }
	}
}
