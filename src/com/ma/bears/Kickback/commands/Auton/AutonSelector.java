package com.ma.bears.Kickback.commands.Auton;

import com.ma.bears.Kickback.RobotValues;
import com.ma.bears.Kickback.commands.Drive.CheesyVisionDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Choose which auton command to run
 * This runs after the AutonSelector is updtated.
 * Runs the apropriate auton mode
 * 
 * @author Brett Levenson blevenson68@gmail.com
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class AutonSelector extends CommandGroup{

    public AutonSelector(int mode){
    	//pass in the auton mode
    	
    	//check which auton mode is selected
        switch(mode){
        	//runs the OneBallStay Command
            case RobotValues.Auton_Do:{
                System.out.println("Do Auton");
                break;
            }
            //runs the CheesyVision Command
            case RobotValues.Auton_CheesyVision:{
                System.out.println("Cheesy Drive Auton");
                addSequential(new CheesyVisionDrive());
            }
            default:{
                System.out.println("Auton selection failed");
                break;
            }
			
        }
    }
}
