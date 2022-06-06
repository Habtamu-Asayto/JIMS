
package com.jservlet.serialcomm;
import com.database.Meritizazandabetuta;
import static com.jservlet.serialcomm.SMSINITIALIZE.today;
import static com.jservlet.serialcomm.SMSINITIALIZE.sms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;
import java.util.logging.Level;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.comm.CommDriver;
import javax.comm.CommPortIdentifier;
import javax.comm.CommPortOwnershipListener;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

public class Sms extends java.util.TimerTask implements SerialPortEventListener, CommPortOwnershipListener, Runnable 
{
    
       
        static int messagestatus = 0;
        String Rmessage;
        static String Smessage;
        String LogMessage = "";
        
        
	/*
	 * Instance Object Logger
	 */
	private static Logger logger = Logger.getLogger(Sms.class);

	/*
	 * Constance status
	 */
	public static final int SC_OK = 0;
	public static final int SC_ERROR = 1;
	public static final int SC_PDU_PARSE_ERROR = 2;
        public static String MessageStatus = "send";

	/*
	 * Flux I/O
	 */
	private OutputStream outStream;
	private InputStream inStream;

	/*
	 * Read incoming SMS from SIM 
	 */
	public IncomingSms rx_sms = null;

	/*
	 * Config Serial Port
	 */
	private SerialParameters parameters;
	
	/*
	 * Communication scan port 
	 */
	private CommPortIdentifier portId;
	
	/*
	 * Communication in serial port 
	 */
	private SerialPort sPort;
	
	
	/*
	 * Status comm port
	 */
	public int portStatus = OK;
	private static Boolean portStatusLock = new Boolean(true);
	private boolean POLLING_FLAG;
	private String portStatusMsg = "";

	/*
	 * Type of response 
	 */
	private static final int OK = 1;
	private static final int WAIT = 2;
	private static final int ERROR = 3;
	private static final int WMSG = 4;
	private static final int RMSG = 5;
	private static final int ECHO = 6;
	private static final int TIMEOUT = 7;
        public static boolean outgoing  = false;
	
	/*
	 * Buffer serial incoming event
	 */
	private byte[] readBuffer = new byte[20000];
	private int bufferOffset = 0; // serialEvent

	/*
	 * LF CR
	 */
	private static final String lfcr = "\r\n";

	/*
	 * Default index memory is 1
	 */
	private int indexCurrentMemory = 1; 
	
	/*
	 * Default memory is "SM"
	 */
	private String currentMemory = "\"SM\""; 
	
	/**
	 * Constructor!
	 * 
	 * @param parameters
	 */
	public Sms(SerialParameters parameters)
	{
		this.parameters = parameters;
	}

	public String initializeWinDrivers()
	{
		String drivername = "com.sun.comm.Win32Driver";
		try
		{
			CommDriver driver = (CommDriver) Class.forName(drivername).newInstance();
			driver.initialize();
			return "successful";
		}
		catch (Throwable th)
		{
			// Discard it
			return "failure";
		}
	}

	/**
	 * Return type of serial port (depend type of driver!) Driver=com.sun.comm.Win32Driver (window)
	 * Driver=gnu.io.RXTXCommDriver (all platform)
	 * 
	 * @param portType
	 * @return String with driver type
	 */
	static String getPortTypeName(int portType)
	{
		// we use on window...
		switch (portType)
		{
			case CommPortIdentifier.PORT_PARALLEL :
				return "Parallel";
			case CommPortIdentifier.PORT_SERIAL :
				return "Serial";
			default :
				return "unknown type";
		}
	}

	/**
	 * Open serial connection with COM port
	 * 
	 * @param _port
	 * @throws IOException
	 */
	public void openConnection(String _port) throws IOException
	{
		openConnection(_port, null);
	}

	/**
	 * Open serial connection with COM port
	 * 
	 * @param _port
	 * @param _pinNumber
	 * @throws IOException
	 */
	public void openConnection(String _port, String _pinNumber) throws IOException
	{
		String port = _port;
		if (_port == null) port = parameters.getPortName();
		
		// Obtain a CommPortIdentifier object for the port you want to open.
		try
		{
			portId = CommPortIdentifier.getPortIdentifier(port);
		}
		catch (NoSuchPortException e)
		{
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
		
		// Open the port represented by the CommPortIdentifier object. Give
		// the open call a relatively long timeout of 30 seconds to allow
		// a different application to reliquish the port if the user
		// wants to.
		try
		{
			sPort = (SerialPort) portId.open("MobileAccess", 5000);
		}
		catch (PortInUseException e)
		{
			throw new IOException(e.getMessage());
		}
		
		// Set the parameters of the connection. If they won't set, close the
		// port before throwing an exception.
		try
		{
			setConnectionParameters();
		}
		catch (IOException e)
		{
			sPort.close();
			throw e;
		}
		
		// Open the input and output streams for the connection. If they won't
		// open, close the port before throwing an exception.
		try
		{
			outStream = sPort.getOutputStream();
			inStream = sPort.getInputStream();
		}
		catch (IOException e)
		{
			sPort.close();
			throw new IOException("Error opening i/o streams");
		}
		// Add this object as an event listener for the serial port.
		try
		{
			sPort.addEventListener(this);
		}
		catch (TooManyListenersException e)
		{
			sPort.close();
			throw new IOException("too many listeners added");
		}
		
		// Set notifyOnDataAvailable to true to allow event driven input.
		sPort.notifyOnDataAvailable(true);
		
		// Add ownership listener to allow ownership event handling.
		portId.addPortOwnershipListener(this);
		
		// init modem connection with pin number
		initializeModem(_pinNumber);
	}

	/**
	 * Initialize modem with PIN number
	 * 
	 * @param pinNumber
	 */
	private void initializeModem(String pinNumber)
	{
		atCmd("ATE0", 0, 1000); 		// turn off command echo
		atCmd("AT+CMEE=2", 0, 500); 	// verbose all messages
		atCmd("AT+CMGF=0", 0, 500); 	// set Pdu mode (default binary)
		//atCmd("AT+CNMI=0,0,0,0", 0, 500);// disable indications -direct to TE?
		
		if (pinNumber != null)
		{
			//enter pin number
			atCmd("AT+CPIN=\"" + pinNumber + "\"", 0, 1000);
			if (portStatus == ERROR)
			{
				logger.error("The pin number " + pinNumber + " is INCORRECT. Please try again.");
                                LogMessage = LogMessage+"The pin number " + pinNumber + " is INCORRECT. Please try again.\n";
                               // System.out.println("setLog+LogMessage");
				// close session!
				this.close();
			}
		}
	}

	/**
	 * List open serial port
	 * 
	 * @return Array String
	 */
	public String[] listPorts()
	{
		Enumeration ports = CommPortIdentifier.getPortIdentifiers();
		ArrayList portList = new ArrayList();
		String portArray[] = null;
		while (ports.hasMoreElements())
		{
			CommPortIdentifier port = (CommPortIdentifier) ports.nextElement();
			if (port.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				portList.add(port.getName());
			}
			portArray = (String[]) portList.toArray(new String[0]);
		}
		return portArray;
	}

	/**
	 * Handles ownership events. If a PORT_OWNERSHIP_REQUESTED event is received a dialog box is created asking the user
	 * if they are willing to give up the port. No action is taken on other types of ownership events.
	 */
	public void ownershipChange(int type)
	{
		if (type == CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED)
		{
			logger.debug("PORT_OWNERSHIP_REQUESTED received : Your port has been requested by an other application...");
                        LogMessage = LogMessage +"PORT_OWNERSHIP_REQUESTED received : Your port has been requested by an other application...\n";
			//System.out.println("setLog+LogMessage");
			this.close();
		}
		else if (type == CommPortOwnershipListener.PORT_OWNED)
		{
			logger.debug("PORT_OWNED received!");
                        LogMessage = LogMessage + "PORT_OWNED received!\n";
                       // System.out.println("setLog+LogMessage");
		}
		else if (type == CommPortOwnershipListener.PORT_UNOWNED)
		{
			logger.debug("PORT_UNOWNED received!");
                        LogMessage = LogMessage + "PORT_UNOWNED received!\n";
                        System.out.println("setLog+LogMessage");
		}
	}

	/**
	 * Sets the connection parameters to the setting in the parameters object. If set fails return the parameters object
	 * to origional settings and throw exception.
	 */
	private void setConnectionParameters() throws IOException
	{
		// Save state of parameters before trying a set.
		int oldBaudRate = sPort.getBaudRate();
		int oldDatabits = sPort.getDataBits();
		int oldStopbits = sPort.getStopBits();
		int oldParity = sPort.getParity();
		int oldFlowControl = sPort.getFlowControlMode();
		
		// Set connection parameters, if set fails return parameters object
		// to original state.
		try
		{
			sPort.setSerialPortParams(parameters.getBaudRate(), parameters.getDatabits(), parameters.getStopbits(),
					parameters.getParity());
		}
		catch (UnsupportedCommOperationException e)
		{
			parameters.setBaudRate(oldBaudRate);
			parameters.setDatabits(oldDatabits);
			parameters.setStopbits(oldStopbits);
			parameters.setParity(oldParity);
			parameters.setFlowControlIn(oldFlowControl);
			parameters.setFlowControlOut(oldFlowControl);
			throw new IOException("Unsupported parameter");
		}
		// Set flow control.
		try
		{
			sPort.setFlowControlMode(parameters.getFlowControlIn() | parameters.getFlowControlOut());
			sPort.enableReceiveThreshold(1);
			sPort.enableReceiveTimeout(2000); // timeout 2s ?!
		}
		catch (UnsupportedCommOperationException e)
		{
			throw new IOException("Unsupported flow control");
		}
	}

	// To be used to send AT command via the IR/serial link to the mobile
	// device (for standard AT commands use mode=0)
	private synchronized int atCmd(String cmd, int mode, int timeout)
	{
		//System.err.println(" this is error i dont konw"+cmd);
		logger.debug(cmd);
                LogMessage = LogMessage +""+cmd+"\n";
                System.out.println("setLog+LogMessage");
		synchronized (portStatusLock)
		{
			portStatus = WAIT;
			try
			{
				// normal end of at command
				if (mode == 0) outStream.write((cmd + lfcr).getBytes()); 	
				
				// end of pdu <CTRL+Z>
				if (mode == 1) 	outStream.write((cmd + "\u001A").getBytes());
				
				// no lfcr: used for polling (just echoed back)
				if (mode == 2) outStream.write((cmd).getBytes());
			}
			catch (IOException e)
			{
				;
			}
			
			// wait for response from device
			try
			{
				// Respond time can vary for different types of AT commands and mobiles!
				portStatusLock.wait(timeout);
			}
			catch (InterruptedException e)
			{
				//...
			}
		}
		return OK;
	}

	/**
	 * Terminates IR/Serial connection to Mobile device
	 */
	public void close()
	{
		// Turn on again command echo
		atCmd("ATE1", 0, 1000);
		if (sPort != null)
		{
			try
			{
				// close the i/o streams.
				outStream.close();
				inStream.close();
			}
			catch (IOException e)
			{
				System.err.println(e);
			}
			
			// Close the port.
			sPort.close();
			
			// Remove the ownership listener.
			portId.removePortOwnershipListener(this);
		}
	}

	/**
	 * Listener Function: Data received from serial link and interpreted
	 */
	public void serialEvent(SerialPortEvent event)
	{
		switch (event.getEventType())
		{
			case SerialPortEvent.BI :
			case SerialPortEvent.OE :
			case SerialPortEvent.FE :
			case SerialPortEvent.PE :
			case SerialPortEvent.CD :
			case SerialPortEvent.CTS :
			case SerialPortEvent.DSR :
			case SerialPortEvent.RI :
			case SerialPortEvent.OUTPUT_BUFFER_EMPTY :
				break;
			case SerialPortEvent.DATA_AVAILABLE :
				int n;
				try
				{
					if (POLLING_FLAG == false)
					{
						while ((n = inStream.available()) > 0)
						{
							n = inStream.read(readBuffer, bufferOffset, n);
							bufferOffset += n;
							String sbuf = new String(readBuffer, 0, bufferOffset); // bufferOffset-2
			
							// lfcr detected, line ready
							if (((readBuffer[bufferOffset - 1] == 10) && (readBuffer[bufferOffset - 2] == 13)))
							{
								// analyzing mobile response
								lineReceived(sbuf);
								if ("ERROR".equals(portStatusMsg))
								{
									System.out.println(portStatusMsg);
									logger.debug(portStatusMsg);
                                                                        LogMessage = LogMessage + "" +portStatusMsg + "\n";
                                                                        System.out.println("setLog+LogMessage");
								}
								bufferOffset = 0;
							}
						}
						
						// delay 1/10 sec
						try { Thread.sleep(100); } catch (Exception ee) {}
					}
					else portStatus = ECHO;
				}
				catch (IOException e)
				{
					;
				}
				break; // end: case SerialPortEvent.DATA_AVAILABLE:
		}
	}

	/**
	 * Used for analyzing mobile response
	 */
	private void lineReceived(String buffer)
	{
		String response;
		StringTokenizer st = new StringTokenizer(buffer, "\r\n");
		rx_sms = null;
		synchronized (portStatusLock)
		{
			while (st.hasMoreTokens())
			{
				response = st.nextToken();
				logger.debug(response);
                                LogMessage = LogMessage + "" + response + "\n";
                                System.out.println("setLog+LogMessage");
				System.out.println(response);
				if (response.startsWith("OK"))
				{
					portStatus = OK;
					portStatusLock.notify();
				}
				else if (response.startsWith(">"))
				{
					portStatus = WMSG;
					portStatusMsg = response;
				}
				else if (response.startsWith("ERROR"))
				{
					portStatus = ERROR;
					portStatusMsg = response;
				}
				else if (response.startsWith("+CME ERROR") || response.startsWith("+CMS ERROR"))
				{
					portStatus = ERROR;
					portStatusMsg = response;
				}
				else if (response.startsWith("07") || response.startsWith("00"))
				{
					portStatus = RMSG;
					try
					{
						rx_sms = new IncomingSms(response);
                                                
                                                java.util.Date tod = new java.util.Date();
                                
                                                String reciveed_date = rx_sms.time.getTime().toLocaleString().substring(0, 6);
                                                String today = tod.toLocaleString().substring(0, 6);
                                                
                                                if (reciveed_date.equals(today)){
                                                logger.debug("SMS received: " + rx_sms.toString());
                                                LogMessage = LogMessage + "" + "SMS received: " + rx_sms.toString() + "\n";
                                                System.out.println("setLog+LogMessage");
                                                Rmessage = Rmessage + "\nSMS received: " + rx_sms.toString();
                                                SMSINITIALIZE.setRPT(Rmessage);
                                                }
						
						
                                                portStatusLock.notify();
					}
					catch (PduParseException e)
					{
						logger.error("Error receiving SMS message: unable to parse PDU:\r\n" + response);
                                                LogMessage = LogMessage + "" + "Error receiving SMS message: unable to parse PDU:\r\n" + response +"\n";
						portStatus = ERROR;
                                                System.out.println("setLog+LogMessage");
					}
				}
				// read sms response
				else if (response.startsWith("+CPMS")) // list sms SM, ME or MT
				{
					portStatus = RMSG;
					portStatusMsg = response;
				}
				else if (response.startsWith("+CMGR")) // read sms OK
				{
					portStatus = RMSG;
					portStatusMsg = response;
				}
				// read phonebook response
				else if (response.startsWith("+CPBR")) // read index phonebook OK
				{
					portStatus = RMSG;
					portStatusMsg = response;
				}
				else if (response.startsWith("+CPBS")) // read current phonebook memory OK
				{
					portStatus = RMSG;
					portStatusMsg = response;
				}
				else if (response.startsWith("+CPBF")) // read find phonebook OK
				{
					portStatus = RMSG;
					portStatusMsg = response;
				}
				// other tips
				else if (response.startsWith("ATE0")) // snoop echo
				{
					portStatus = ECHO;
					portStatusMsg = response;
				}
				else
				{
					//...
				}
			}
		}
		return;
	}

	/**
	 * Send an SMS to number (using SMS central having number "smsc_number")
	 */ 
	public synchronized void SendMessage(String number, String smsc_number, String msg)
	{
		// to specify specific SMS settings (character coding, sms type, ...)
		int tpPid = 0x00;
		int tpDcs = 0x00;
                 System.out.println("Fine until Here send mesage try------");
		
		if (number.startsWith("+")) number = number.substring(1);
		if (smsc_number.startsWith("+")) smsc_number = smsc_number.substring(1);
		try
		{
                    System.out.println("here is phone and  and smscs ->"+number);
                           System.out.println("here is phone and  and smscs ->"+smsc_number);
                    
                       
                   	OutgoingSms pdumsg = new OutgoingSms(number, smsc_number, msg, tpPid, tpDcs);
                          
			String cmd = "AT+CMGS=" + pdumsg.length();
			String pdu = pdumsg.toString();
                         System.out.println("PDU prossed and pDU is"+pdu);
                        
			try{
                        Thread.sleep(1000);
                        }catch(Exception e)
                        {
                         System.out.println(" Error happened ");
                        }
			// Delay needed -> Waiting for ">" Prompt, otherwise Error MSG!
			int a=atCmd(cmd, 0, 500);
                         System.out.println(" here is a ====>"+a);
                        
			
			// For some mobiles > 1000 ms!
		int b =atCmd(pdu, 1, 3500);
                System.out.println(" here is b ====>"+b);
                  MessageStatus = "send";
                  
                System.out.println("yes soloution is here  "  +MessageStatus);
                          
                }
		catch (Exception e)
		{
                    System.out.println("Error is "+e.getMessage());
                        outgoing=false;
			logger.error("Irregular SMS format"+e.getMessage());
                        LogMessage = LogMessage + "Irregular SMS format\n";
                        System.out.println("setLog+LogMessage");
                        
                        
		}
                outgoing=true;
                System.out.println("Just finish sending here !!!!!!!!!!!!!!!!");
	}

	/**
	 * Send an SMS from index memory
	 */ 
	public synchronized void SendMessageStore(int index_mem, String number)
	{
		if (number.startsWith("+")) number = number.substring(1);
		try
		{
			// AT+CMSS= index [,da [,toda]]
			String cmd = "AT+CMSS=" + index_mem + "," + number;
			atCmd(cmd, 0, 3000);
                        System.out.println(" here is inside storage i don't know if it is last  and port status is  \n"+portStatus);
		}
		catch (Exception e)
		{
			logger.error("Irregular SMS format");
                        LogMessage = LogMessage +"Irregular SMS format\n";
                        System.out.println("setLog+LogMessage");
		}
	}

	/**
	 *  Write SMS to phone/SIM memory (transmit format)
	 */ 
	public synchronized void WriteTextMessage(String number, String smsc_number, String msg)
	{
		// to specify specific SMS settings (character coding, sms type, ...)
		int tpPid = 0x00;
		int tpDcs = 0x00;
		if (number.startsWith("+")) number = number.substring(1);
		if (smsc_number.startsWith("+")) smsc_number = smsc_number.substring(1);
		try
		{
			OutgoingSms pdumsg = new OutgoingSms(number, smsc_number, msg, tpPid, tpDcs);
			String cmd = "AT+CMGW=" + pdumsg.length();
			String pdu = pdumsg.toString();
			atCmd(cmd, 0, 500);
			atCmd(pdu, 1, 1500);
		}
		catch (Exception e)
		{
			logger.error("Irregular SMS format");
                        LogMessage = LogMessage + "Irregular SMS format\n";
                        System.out.println("setLog+LogMessage");
		}
	}

	/**
	 *  Write SMS to phone/SIM memory (received format, write problem with some phone/SIM)
	 */ 
	public synchronized void WriteTextUnReadMessage(String number, String smsc_number, String msg)
	   {
		// to specify specific SMS settings (character coding, sms type, ...)
		int tpPid = 0x00;
		int tpDcs = 0x00;
		if (number.startsWith("+")) number = number.substring(1);
		if (smsc_number.startsWith("+")) smsc_number = smsc_number.substring(1);
		try
	     	{
			OutgoingSms pdumsg = new OutgoingSms(number, smsc_number, msg, tpPid, tpDcs);
			Calendar time = new GregorianCalendar();
			//time.set(Calendar.MINUTE, -5);
			pdumsg.transform_to_received_SMS(time);
			String pdu_r = pdumsg.toString();
			
			// Important: PDU of SMS to be stored in RECEIVED UNREAD (,0) folder
			// must follow received SMS PDU format!
			String cmd_r = "AT+CMGW=" + pdumsg.length() + ",0";
			atCmd(cmd_r, 0, 500);
			atCmd(pdu_r, 1, 1500);
		}
		catch (Exception e)
		{
			logger.error("Irregular SMS format");
                        LogMessage = LogMessage + "Irregular SMS format";
                        System.out.println("setLog+LogMessage");
		}
	}

	/**
	 * Read SMS from Mobile/SIM storage having index i
	 */ 
	public synchronized void ReadSMS(int i)
	{
		atCmd("AT+CMGR=" + i, 0, 1000); // Receive SMS
	}

	/**
	 * Delete SMS from Mobile/SIM storage having index i
	 */ 
	public synchronized void DeleteSMS(int i)
	{
		atCmd("AT+CMGD=" + i, 0, 1000); // Delete SMS
	}

	/**
	 *  get SMS from Mobile/SIM storage
	 */ 
	public synchronized IncomingSms getRxMS()
	{
		return rx_sms;
	}
	
	/**
	 * get error message & other...
	 */ 
	public synchronized String getPortStatusMsg()
	{
		return portStatusMsg;
	}

	/**
	 * get port status...
	 */ 
	public synchronized int getPortStatus()
	{
		return portStatus;
	}

	/**
	 * Get current size list of SMS strored in particulary memory example = \"ME\",\"SM\",\"MT\"
	 *  "ME": ME phonebook 
	 *  "SM": SIM phonebook 
	 *  "MT": combined ME and SIM phonebook
	 * 
	 * @return int Size list of sms in specific memory
	 */
	public synchronized int getSizeListSMS()
	{
		atCmd("AT+CPMS=" + currentMemory, 0, 500);
		
		// receive error message ?
		if (portStatus == ERROR) return 1; // index list start 1 not 0!
		
		// parse response
		try
		{
			String str = portStatusMsg.substring(portStatusMsg.indexOf(':') + 1, portStatusMsg.length());
			String[] str2 = getArrayString(str);
			if (str2.length >= 2) str = str2[1]; // size used
			str = str.trim();
			
			// index current memory
			indexCurrentMemory = 1; // 1 for Sms
			
			return Integer.parseInt(str);
		}
		catch (java.lang.StringIndexOutOfBoundsException e)
		{
			return 1;
		}
		catch (NumberFormatException ee)
		{
			return 1;
		}
	}
	
	

	/**
	 * Get Size list of PhoneBook strored in particulary memory :
	 * 
	 *  Commonly available phonebooks are: 
	 *	FD : SIM fixdialling-phonebook 
	 *  LD : SIM last-dialling-phonebook 
	 *  ME : ME phonebook 						(the indexes begin from 750 to 999)
	 *  MT : combined ME and SIM phonebook  	(the indexes begin from 1 to 80) 
	 *	SM : SIM phonebook 						(the indexes begin from 1 to 80) 
	 *  TA : TA phonebook
	 * 
	 * @return int Size list of Phone Book in specific memory
	 */
	public synchronized int getSizeListPhoneBook()
	{
		// Check which indexes are available for reading in the selected memory
		atCmd("AT+CPBR=?", 0, 500);
		
		// receive error message ?
		if (portStatus == ERROR) return 1; // index list start 1 not 0!
		
		// parse response
		try
		{
			String str1 = portStatusMsg.substring(portStatusMsg.indexOf('(')+1, portStatusMsg.indexOf('-'));
			str1 = str1.trim(); // System.out.println("str1 : " + str1);
			
			// index current memory
			indexCurrentMemory = Integer.parseInt(str1);
			
			String str2 = portStatusMsg.substring(portStatusMsg.indexOf('-')+1, portStatusMsg.indexOf(')'));
			str2 = str2.trim(); // System.out.println("str2 : "+ str2);
			
			return (Integer.parseInt(str2) - Integer.parseInt(str1));
		}
		catch (java.lang.StringIndexOutOfBoundsException e)
		{
			return 1;
		}
		catch (NumberFormatException ee)
		{
			return 1;
		}
	}
	
	
	
	/**
	 * Read PhoneBook Mobile/SIM storage having index i
	 */ 
	public synchronized String getPhoneBook(int i)
	{
		atCmd("AT+CPBR=" + i, 0, 1000); // get PhoneBook index i  
		
		String book = "";
		
		// receive error message ?
		if (portStatus == ERROR) return book; 
		
		// parse reponse... +CPBR: 750,"33600000000",145,"TOTO"
		try
		{
			book = portStatusMsg.substring(portStatusMsg.indexOf(':')+1, portStatusMsg.length());
			book = book.trim();
		}
		catch (java.lang.StringIndexOutOfBoundsException e)
		{
			return "";
		}
		catch (NumberFormatException ee)
		{
			return "";
		}
		
		// return string of phone book 
		return book;
	}
	
	
	
	/**
	 * Search PhoneBook from Mobile/SIM storage, example : "A"
	 */ 
	public synchronized String SearchPhoneBook(String search_name)
	{
		atCmd("AT+CPBF="+"\""+search_name+"\"", 0, 1000); // Search PhoneBook
		
		String book = "";
		
		// receive error message ?
		if (portStatus == ERROR) return book; 
		
		// parse reponse... +CPBF: 750,"33600000000",145,"TOTO"
		try
		{
			book = portStatusMsg.substring(portStatusMsg.indexOf(':')+1, portStatusMsg.length());
			book = book.trim();
		}
		catch (java.lang.StringIndexOutOfBoundsException e)
		{
			return "";
		}
		catch (NumberFormatException ee)
		{
			return "";
		}
		
		// return string of phone book 
		return book;
	}
	
	
	
	/**
	 *  Write PhoneBook to phone/SIM memory (received format, write problem with some phone/SIM)
	 */ 
	public synchronized boolean WritePhoneBookMessage(int index, String number, int type, String name)
	{
		//if (number.startsWith("+")) number = number.substring(1);
	
		// Write phone number and name in phonebook index
		String cmd_r = "AT+CPBW="+ index+ "," +"\""+ number +"\""+ ","+type+ "," +"\""+name+"\",0";
	
		// Confirm what we have just written
		String cmd_c = "AT+CPBR="+ index;
	
		try
		{
			// send write command phone book
			atCmd(cmd_r, 0, 500);
			
			// receive error message ?
			if (portStatus == ERROR) return false; 
			
			// confirm write command phone book
			atCmd(cmd_c, 0, 500);
			
			// receive error message ?
			if (portStatus == ERROR) return false; 
			
			// parse reponse... +CPBR: 750,"33600000000",145,"TOTO"
			try
			{
				String book = portStatusMsg.substring(portStatusMsg.indexOf(':')+1, portStatusMsg.length());
				book = book.trim();
		
				// same request ?
				if (book.equals(cmd_r)) return true;
			}
			catch (java.lang.StringIndexOutOfBoundsException e)
			{
				return false;
			}
			catch (NumberFormatException ee)
			{
				return false;
			}
		}
		catch (Exception e)
		{
			logger.error("Irregular PhoneBook format");
                        LogMessage = LogMessage + "Irregular PhoneBook format\n";
                        System.out.println("setLog+LogMessage");
		}
		
		return false;
	}

	
	/**
	 * Delete PhoneBook from Mobile/SIM storage having index i
	 */ 
	public synchronized void DeletePhoneBook(int i)
	{
		atCmd("AT+CPBW=" + i, 0, 1000); // Delete Phone Book index
	}
	
	
	/**
	 * Method getPhoneBookMemory
	 * 
	 * @return String	Name of current phonebook memory
	 */
	public synchronized String getPhoneBookMemory()
	{
		String memory ="";
		
		// ask memory
		atCmd("AT+CPBS?", 0, 500);
		
		// receive error message ?
		if (portStatus == ERROR) return memory; 
		
		try
		{
			memory = portStatusMsg.substring(portStatusMsg.indexOf('"'), portStatusMsg.indexOf('"')+4);
			memory = memory.trim();
			
			currentMemory = memory;
		}
		catch (java.lang.StringIndexOutOfBoundsException e)
		{
			return "";
		}
		catch (NumberFormatException ee)
		{
			return "";
		}
		
		return memory;
	}
	
	/**
	 * Method getSmsMemory
	 * 
	 * @return String	Name of current sms memory
	 */
	public synchronized String getSmsMemory()
	{
		String memory ="";
		
		// ask memory
		atCmd("AT+CPMS?", 0, 500);
		
		// receive error message ?
		if (portStatus == ERROR) return memory; 
		
		try
		{
			memory = portStatusMsg.substring(portStatusMsg.indexOf('"'), portStatusMsg.indexOf('"')+4);
			memory = memory.trim();
			
			currentMemory = memory;
		}
		catch (java.lang.StringIndexOutOfBoundsException e)
		{
			return "";
		}
		catch (NumberFormatException ee)
		{
			return "";
		}
		
		return memory;
	}
	
			
			
	/**
	 * Init current phone book memory
	 * 
	 * @param typeStore
	 * @return boolean		true if memory is initialized
	 */
	public synchronized boolean initializePhoneBookMemory(String typeStore)
	{
		boolean initOk = true;
		
		// inint memory
		atCmd("AT+CPBS=" + typeStore, 0, 500);
		
		// receive error message ?
		if (portStatus == ERROR) return false; 
		
		// set current type memory
		currentMemory = typeStore;
		
		return initOk;
	}
	
	/**
	 * Init current sms memory
	 * 
	 * @param typeStore
	 * @return boolean		true if memory is initialized
	 */
	public synchronized boolean initializeSmsMemory(String typeStore)
	{
		boolean initOk = true;
		
		// inint memory
		atCmd("AT+CPMS=" + typeStore, 0, 500);
		
		// receive error message ?
		if (portStatus == ERROR) return false; 
		
		// set current type memory
		currentMemory = typeStore;
		
		return initOk;
	}
	
	/**
	 * Get index of the current memory
	 * 
	 * @return int
	 */
	public int getIndexMemory()
	{
		return this.indexCurrentMemory;
	}
	
	/**
	 * Method getArrayString
	 * 
	 * @param response
	 * @return String[]
	 */
	private static String[] getArrayString(String _str)
	{
		// test _str
		if (_str == null) return new String[0];
		StringTokenizer b_stk = new StringTokenizer(_str, ",");
		String[] str = new String[b_stk.countTokens()];
		int count = 0;
		while (b_stk.hasMoreTokens()) str[count++] = b_stk.nextToken();
		return str;
	}
    
	
  @Override
    public void  run() {
              /*  SendNeonateMessage_HosDelivery();
                reciveNeonateMessage();
                SendNeonateMessage_PREGNANCYHOSPITAL();
                reciveNeonateMessage_Pre_HosPregnancy();
                      */
        //   test(); 
   }
    
    public void  runonrefresh() {
            try {
                process();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Sms.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
  
  @PersistenceContext(unitName = "WeredaFitihPU")
  private EntityManager em;
  @Inject
  UserTransaction ut;
    public void persist(Object object) {
        em.persist(object);
    }
      List <Meritizazandabetuta> pt;

        String year=null;
    
          EntityTransaction entityTransaction ;
          
       String [][]datatobeupdated;
        String [][]weeklydatatobeupdated;
   EntityManagerFactory emf;
UserTransaction transaction;
 public List<Meritizazandabetuta> getList() throws ParseException
{
  Date now=new java.util.Date();
   DateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
       java.util.Date dTemp = null;
      dTemp = formatter.parse(now.toString());
     formatter = new SimpleDateFormat("dd- MMM-yyyy");
           String ethdate = formatter.format(dTemp);
         today=ethdate;
           String parts[]=ethdate.split("-");
          String year=parts[2];
         
   //  return em.createQuery("SELECT d FROM Meritizazandabetuta d").getResultList();
          
return em.createQuery("SELECT d FROM Meritizazandabetuta d WHERE d.ketero = :ketero").setParameter("ketero",today).getResultList();
}
  
  public void updaterow(String  idd,String val, int daynumber) throws  Exception
{   
    int day=daynumber+1;
    Meritizazandabetuta  dr = em.find(Meritizazandabetuta.class, processKey(idd));
   String name=dr.getGlglaotteyakiname();
   String kesash_phone = dr.getPhonekesash();
String tekesash_phone=dr.getPhonetekesash();
   String kphone=kesash_phone.substring(1, 5)+kesash_phone.substring(7, 10)+kesash_phone.substring(11, 13)+kesash_phone.substring(14, 18);
   String tekphone=tekesash_phone.substring(1, 5)+tekesash_phone.substring(7, 10)+tekesash_phone.substring(11, 13)+tekesash_phone.substring(14, 18);
   
   outgoing = true; 
    if (getPortStatus() == ERROR){
            Smessage = Smessage +"\n----> Error : SMS not SEND !\nYou probably dont have enogh account";
            Smessage = Smessage + "\n today reminder  has not been send to: "+kphone+"\n";
            SMSINITIALIZE.setSETA(Rmessage);
            
               }
       else  
     {
               
       try{    
  if(day==1){  
 SendMessage(kphone, "+251911299708", "1");
  dr.setKesashmessegeflag("1");
     
 
  Smessage = Smessage + "\nMessage For =>" + name + "Schedule  => "+day+" ready to be send... and outgoing status is "+outgoing+"\n";
  SMSINITIALIZE.setSPT(Smessage);  

  if(outgoing==true){
  outgoing=false;
  MessageStatus = "sendreset";
  Smessage += Smessage + "\n DAY "+day+" REMINDER has been send to: "+kphone+"\n";
  SMSINITIALIZE.setSPT(Smessage);

  em.persist(dr);
  }
  }//// kesash messege send 
  if(day==2){  
 SendMessage(tekphone, "+251911299708", "1");
  dr.setTekesashmessegeflag("1");
     
 
  Smessage = Smessage + "\nMessage For =>" + name + "Schedule  => "+day+" ready to be send... and outgoing status is "+outgoing+"\n";
  SMSINITIALIZE.setSPT(Smessage);  

  if(outgoing==true){
  outgoing=false;
  MessageStatus = "sendreset";
  Smessage += Smessage + "\n DAY "+day+" REMINDER has been send to: "+tekphone+"\n";
  SMSINITIALIZE.setSPT(Smessage);

  em.persist(dr);
  } // tekesash messege send 
  }
  
  else
  {
    Smessage += Smessage + "\nMessage For =>" + name + "Schedule  => "+day+"== is interrupted";
   SMSINITIALIZE.setSPT(Smessage);  
  }
  
        }
  catch(Exception e)
        {
      Smessage = Smessage + sms.getPortStatusMsg();
      Smessage = Smessage + e.getMessage();
        
        }
  
                         }
      
}
public void checkdatas() throws Exception
{

     int si=0;
     
    for(int i=0;i<x;i++)
{
for(int j=0;j<4;j++)
{

    if(datatobeupdated[i][j]!=null)
    {

  si+=1;
 }
            }
            }

   
 if(si>0)
    Smessage = Smessage + "\nTotally  " + si + " SMS Reminder found   to be Send ";
   else
       Smessage = Smessage + "\n No Mother has found with today Schedule ";
     SMSINITIALIZE.setSPT(Sms.Smessage);
for(int i=0;i<x;i++)
{
for(int j=0;j<4;j++)
{

    if(datatobeupdated[i][j]!=null)
    {
  String []parts=datatobeupdated[i][j].split(",");
  updaterow (parts[0], parts[1],j);
      }
            }
            }

}
  java.math.BigDecimal processKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        } 
 static int x;
public void process() throws Exception
{
   pt=getList();
   x=pt.size();
   datatobeupdated=new String[x][1];
   int i=0;
    for(Meritizazandabetuta  dr:pt)
    {
     // if(dr.get.equalsIgnoreCase("Enable")){
   if(today.equalsIgnoreCase(dr.getKetero()) && dr.getKesashmessegeflag().equalsIgnoreCase("0"))
     {
  datatobeupdated[i][0]=dr.getId()+","+dr.getKesashmessegeflag();
  System.out.println("This is New Kesash To send ===>"+dr.getId()+","+dr.getKesashmessegeflag());
    }
   
      // } // check enabled
        i++;
    }
    Rmessage="database is running well ";
  checkdatas();

    }
  public  void init() throws ParseException, Exception
  {
     
process_registration_messege();
//   emf=Persistence.createEntityManagerFactory("SMSIMMUNIZATIONPU");
//   em=emf.createEntityManager();
//   em.clear();
//   em.getTransaction().begin();
//  process();
//   em.getTransaction().commit();
//   sms.recive_sms_messeges();
      
     
              
  }
 public void recive_sms_messeges(){
                       int len_sms = sms.getSizeListSMS();
			
			int index_sms = sms.getIndexMemory();
                 
                        boolean noNewMessage = true;
                     
			for(int i=index_sms; i<=len_sms; i++)
			{
		      
                            sms.ReadSMS(i);
   
				 //test if last message is a error  
				if (sms.getPortStatusMsg().startsWith("+CMS ERROR")) 
                                     break;
					
				// get incoming sms
				IncomingSms in_sms = sms.getRxMS();
                      System.out.println("this is messege   content " +"size "+i+"  ---->  ");
                                java.util.Date tod = new java.util.Date();
                          
                                String reciveed_date = "";
                                
                                if(in_sms != null)
                                reciveed_date = in_sms.time.getTime().toLocaleString().substring(0, 6);
                                      
                                String today = tod.toLocaleString().substring(0, 6);
                                
                                if (in_sms != null && reciveed_date.equals(today))
				{
                                    if (in_sms.senderAddress.equals("+251994")||in_sms.senderAddress.equals("251994")){
                                    
                                        JOptionPane.showMessageDialog(null,in_sms.msg);
                                        sms.DeleteSMS(i);
                                    }
                                    else{
                                          Rmessage = Rmessage+"\n======= Currently Received SMS Message ======= \nReceived Date: "+in_sms.time.getTime() + "\nSender Address: "+in_sms.senderAddress+ "\nMessage: "+in_sms.msg+"\n";
                                        SMSINITIALIZE.setRPT(Rmessage);
                                             sms.DeleteSMS(i);
                                            }
             }
                                
                        }
                        if (noNewMessage == true){
                                    
                                    java.util.Date nowTime = new java.util.Date();
                                    Rmessage = Rmessage + "\nNo new message received at: \n"+nowTime.toLocaleString();
                                    SMSINITIALIZE.setRPT(Rmessage);                       
                        }
}
   
  

 public void process_registration_messege() throws ClassNotFoundException, SQLException
 {
  int delivid;
   String kesash_phone ;
   Connection con ;
    PreparedStatement ps = null;
     ResultSet rs = null;
   PreparedStatement ps1 = null ;
   String tekesashphone=null;
     System.out.println("Testing registration messege");
    
  Class.forName("oracle.jdbc.driver.OracleDriver");
  try{
                      con  = DriverManager.getConnection("jdbc:oracle:thin:woredafitih/weredafitihuog@localhost");
                        String sql = "select  * from Meritizazandabetuta where  ((REGISTRATIONMESSAGEFLAG = '0' or tekesashregistration ='0') and  (phonekesash <> 'null' or phonetekesash <> 'null'))";
                        ps= con.prepareStatement(sql);
                       rs = ps.executeQuery();
                         
                             System.out.println("sql is generated");
                        while(rs.next())
                        {
                       delivid=rs.getInt("ID");
                         // String mothername = rs.getString("name");
                       tekesashphone=rs.getString("phonetekesash");
                        kesash_phone  = rs.getString("phonekesash");
               if(kesash_phone!=null)
               {
                   System.out.println("kesash stated");
                String mp=kesash_phone.substring(1, 5)+kesash_phone.substring(7, 10)+kesash_phone.substring(11, 13)+kesash_phone.substring(14, 18);
               SendMessage(mp, "+251911299708", "5");
               Thread.sleep(2000);
              
               
                     System.out.println(" after sending");  
                    if(outgoing==true){
  outgoing=false;
  MessageStatus = "sendreset";
  Smessage = Smessage + "\n Registration Messege has been send to: "+mp+"\n";
  SMSINITIALIZE.setSPT(Smessage);
   System.out.println(Smessage+"for Phone"+mp);
   String d = "UPDATE Meritizazandabetuta set  REGISTRATIONMESSAGEFLAG=? where ID=?";
ps1= con.prepareStatement(d);
                                ps1.setString(1, "1");
                                ps1.setInt(2, delivid);
                               
                           int row = ps1.executeUpdate();
                                System.out.println(" ready to update");
                           if(row>0)
                           {
                           System.out.println(" row updated successfully for kesash");
                           
    System.out.println("kesash end");                       }
  }
               
  else
  {
    Smessage = Smessage + "\n Registration Message For =>" + mp + "is interrupted";
   SMSINITIALIZE.setSPT(Smessage);  
  }
               
                        }// end of sms kesash 
  if(tekesashphone!=null)
               {
                    System.out.println("tekesash started");   
                String mp=tekesashphone.substring(1, 5)+tekesashphone.substring(7, 10)+tekesashphone.substring(11, 13)+tekesashphone.substring(14, 18);
               SendMessage(mp, "+251911299708", "5");
               Thread.sleep(5000);
              
               
                     System.out.println(" after sending");  
                    if(outgoing==true){
                        
  outgoing=false;
  MessageStatus = "sendreset";
  Smessage = Smessage + "\n Registration Messege has been send to: "+mp+"\n";
  SMSINITIALIZE.setSPT(Smessage);
    System.out.println(Smessage+"for Phone"+mp);
   String d = "UPDATE Meritizazandabetuta set  tekesashregistration=?  where ID=?";
ps1= con.prepareStatement(d);
                                ps1.setString(1, "1");
                                ps1.setInt(2, delivid);
                               
                           int row = ps1.executeUpdate();
                                System.out.println(" ready to update");
                           if(row>0)
                           {
                           System.out.println(" row updated successfully for tekesash ");
                           
                           }
                           System.out.println("tekesash end"); 
  }
               
  else
  {
    Smessage = Smessage + "\n Registration Message For =>" + mp + "is interrupted";
   SMSINITIALIZE.setSPT(Smessage);  
  }
               
                        }// tekesash              
               
                        }
     
 
 }catch(Exception e){
 System.out.println(" there  is error inside registration messege"+e.getMessage());
}


 }
}
