/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jservlet.serialcomm;

import java.io.IOException;
import javax.comm.SerialPort;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Admin
 */
public class Recive {
    
    public static void main( String arg[] ){
    
     BasicConfigurator.configure();
		// Config serial port parameters!
		SerialParameters params = new SerialParameters();
		params.setPortName("COM5"); // default COM1
		params.setBaudRate(115200); // default 115200
		params.setFlowControlIn(SerialPort.FLOWCONTROL_NONE); // default none flowcontrol
		params.setFlowControlOut(SerialPort.FLOWCONTROL_NONE); // default none flowcontrol
		params.setDatabits(SerialPort.DATABITS_8); // default data bits 8
		params.setStopbits(SerialPort.STOPBITS_1); // default stop bits 1
		params.setParity(SerialPort.PARITY_NONE); // default none parity bits 1
		
		// object sms client
		Sms sms = new Sms(params);
                
                
                
                try
		{
			sms.openConnection("COM5");//, "1111"); // COM1, optional pin code
			
                sms.serialEvent(null);
			
			
		}
		catch (IOException e)
		{
			System.err.println("Communication problem :" + e);
			e.printStackTrace();
		}
		finally
		{
			// close connection to serial port / modem
			try { sms.close(); } catch (NullPointerException ex) {}
		}
                
                
    
    }
    
}
