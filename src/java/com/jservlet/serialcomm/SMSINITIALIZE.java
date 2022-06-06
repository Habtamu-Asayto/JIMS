
package com.jservlet.serialcomm;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.SerialPort;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;
import org.apache.log4j.BasicConfigurator;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.chrono.GregorianChronology;

/**
 *
 * @author fedlu
 */
@ManagedBean (name = "smsprocess")
@SessionScoped
public class SMSINITIALIZE {
     public static Sms sms;
 static String Day_One_Msg;
 static String Day_Three_Msg;
 static String Day_Two_Msg;
 static String Registration_Message;
String sample;

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
 static String sinterface;
  static String NMRM;
    static String RPT;
  static String SETA;
   static String SPT;
 static boolean once = false;
    public static String getNMRM() {
        return NMRM;
    }

    public static void setNMRM(String NMRM) {
        SMSINITIALIZE.NMRM = NMRM;
    }

    public static String getRPT() {
        return RPT;
    }

    public static void setRPT(String RPT) {
        SMSINITIALIZE.RPT = RPT;
    }

    public static String getSETA() {
        return SETA;
    }

    public static void setSETA(String SETA) {
        SMSINITIALIZE.SETA = SETA;
    }

    public static String getSPT() {
        return SPT;
    }

    public static void setSPT(String SPT) {
        SMSINITIALIZE.SPT = SPT;
    }
    public static String getSinterface() {
        return sinterface;
    }

    public static void setSinterface(String sinterface) {
        SMSINITIALIZE.sinterface = sinterface;
    }
    static String today;

    public static String getToday() {
        return today;
    }

    public static void setToday(String today) {
        SMSINITIALIZE.today = today;
    }
 public static String ConvertToEthiopian( int gregorianYear, int gregorianMonth, int gregorianDay) {
    Chronology chron_eth = EthiopicChronology.getInstance();
    Chronology chron_greg = GregorianChronology.getInstance();
    DateTime jodaDateTime = new DateTime(gregorianYear, gregorianMonth, gregorianDay, 0, 0, 0, chron_greg);
    DateTime dtEthiopic = jodaDateTime.withChronology(chron_eth);
    String[] monthsArray = {"meskerem","tikimt","hidar","Tahsas","Tir","Yekatiti","Megabit","Miazia","Ginbot","sene","Hamle","Nehasie","Pagume"};
   // String dateInEthiopian = dtEthiopic.getDayOfMonth()<10 ?"0"+dtEthiopic.getDayOfMonth():dtEthiopic.getDayOfMonth() + "/" + (dtEthiopic.getMonthOfYear()<10)? "0"+dtEthiopic.getMonthOfYear():dtEthiopic.getMonthOfYear()  + "/" + dtEthiopic.getYear();
    int day=dtEthiopic.getDayOfMonth();
    int mon=dtEthiopic.getMonthOfYear();
    
   
    int year=dtEthiopic.getYear();
    String builder;
    String d=day<10? "0"+day:day+"";
    String m=mon<10? "0"+mon:mon+"";
          
   
    return d+"/"+ m+"/"+year+"";
}
    public void initialize() throws ClassNotFoundException, SQLException {
        System.out.println("Initialization called");
         BasicConfigurator.configure();
        SerialParameters params = new SerialParameters();
        params.setPortName("COM3"); // default COM1
        params.setBaudRate(115200); // default 115200
        params.setFlowControlIn(SerialPort.FLOWCONTROL_NONE); // default none flowcontrol
        params.setFlowControlOut(SerialPort.FLOWCONTROL_NONE); // default none flowcontrol
        params.setDatabits(SerialPort.DATABITS_8); // default data bits 8
        params.setStopbits(SerialPort.STOPBITS_1); // default stop bits 1
        params.setParity(SerialPort.PARITY_NONE); // default none parity bits 1
        sms = new Sms(params);
        
        try {
 
            
            Calendar calendar =Calendar.getInstance(); 
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH)+1;
int day = calendar.get(Calendar.DAY_OF_MONTH);
  today= ConvertToEthiopian(year, month, day);
      
                Sms.Smessage = Sms.Smessage+"\nDriver loading... " + sms.initializeWinDrivers()+"\n";
               setSinterface(Sms.Smessage);
               setSample(Sms.Smessage);
                sms.openConnection("COM3");
                
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Sms.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"javax.comm.NoSuchPortException ===> \nThe USB cable must be pluged in to COM PORT 5 (COMP5) ");
                                        
            }
     Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:woredafitih/weredafitihuog@localhost");
                        String sql = "SELECT * FROM Messege";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            Day_One_Msg = rs.getString("DAY_ONE");
                            Day_Two_Msg = rs.getString("DAY_TWO");
                            Day_Three_Msg = rs.getString("Day_Three_Msg");
                            Registration_Message = rs.getString("REGISTRATION_MESSAGE");
                         }
                        rs.close();
                        ps.close();
                        con.close();
        
        
    
    }
    public void sendSmsProcess()
    {
     try {
          System.out.println("sending started called");
            // System.out.println("The size in sim is===>"+ sms.getSizeListSMS());
             sms.init();
             
             //Detect Database Change
             //  OracleDCN oracleDCN = new OracleDCN();
             // oracleDCN.StartDBListner();

             /* Create and display the form */
         } catch (Exception ex) {
             Logger.getLogger(SMSINITIALIZE.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
    }
    
     
}
