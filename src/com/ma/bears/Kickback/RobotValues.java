package com.ma.bears.Kickback;

/**
 * Declare robot values, such as default speed of a motor,
 * in a convenient place that allows us to change them
 * quickly without sorting through code.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */
public class RobotValues {
	
	//Make all distances forward negative and backwards positive
    
    //cheesy drive
    public static final double sensitivityHigh = .85;
    public static final double sensitivityLow = .75;
    
    //drive
    public static final double Kp = 10.0;
    public static final double Kd = 0.8;
    public static final double driveTolerance = .01;
    
    //Auton    
            
    public static final int Auton_Disabled = -1;
    public static final int Auton_Empty = 0;
    public static final int Auton_Do = 1; 
    public static final int Auton_CheesyVision = 2;
    //if you increment the values above you must also increment the Auton_Max
        
    public static final int Auton_Max = 2;
}
