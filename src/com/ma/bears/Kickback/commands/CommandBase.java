package com.ma.bears.Kickback.commands;

import com.ma.bears.Kickback.OI;
import com.ma.bears.Kickback.Ports;
import com.ma.bears.Kickback.subsystems.Drive;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Create instances of the subsystems here
 * Later in commands import this class to
 * gain access to the systems presets
 *
 * @author Nick Ivy nickyivyca@gmail.com
 */
public abstract class CommandBase extends Command{
	
    //public static Compressor Compressor = new Compressor();
    public static Drive Drive = new Drive();
    public static OI OI = new OI();

    public static Compressor Compr = new Compressor(Ports.DIO_Pressure, Ports.Relay_Compr);
    
    public static void init(){
    	Compr.start();
    }

}
