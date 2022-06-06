package process;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PNCprocess implements Serializable {

    Connection con;
    ResultSet rs;

    public void action() {
        try {
            
         Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:mhealth/mhealth@localhost");
              // String sql = "SELECT * FROM hosdelivery";
               String sql = "SELECT * FROM hosdelivery where MOTHER_STATUS=? ";
               PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, "Live");
                 rs=ps.executeQuery();
                 
             java.util.Date tod= new java.util.Date();
            DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT);
            String today=df.format(tod);
      
                while (rs.next()) {
    //System.out.println("=name  =====   "+rs.getString(8)+"id is"+ rs.getInt(2) + today+"  the first day is   "+rs.getString(18));	
    System.out.println("cheking-------"+rs.getString("SCHEDULEONE") +"===="+rs.getString("FULL_NAME")+"====== "+rs.getString("SCHEDULEONEFLAG"));
   
   // if(today.equalsIgnoreCase(rs.getString("SCHEDULEONE") ) || (rs.getString("SCHEDULEONEFLAG").equalsIgnoreCase("off")))
    if(today.equalsIgnoreCase(rs.getString("SCHEDULEONE") ) && "notsent".equalsIgnoreCase(rs.getString("SCHEDULEONEFLAG") )  )
                        {
          System.out.println("cheking-------for update");
          String d="UPDATE hosdelivery set  REMINDERSTATUS=?, REMINDERTYPE=? ,SCHEDULEONESTATUS=?,SCHEDULEONEFLAG =? where MOTHER_REGISTRATION_ID=?";
                  FileWriter writer = new FileWriter("C:\\message\\MyFile.txt", true);
                  writer.write("Welcome "+ rs.getString("FULL_NAME") + " Send Message  "+ "for "+rs.getString("SCHEDULEONE")+"=======  sent time"+ new java.util.Date().toString());
	          writer.write("\r\n");	
                  writer.close();
                  PreparedStatement ps2=con.prepareStatement(d);
                 ps2.setString(1,"UNCONFIRMED");
                 ps2.setString(2,"DAY ONE");
                  ps2.setString(3,"sent");
                  ps2.setString(4, "sent");
                 ps2.setInt(5,rs.getInt(2)); 
                 int row=ps2.executeUpdate();
            //   System.out.println(" \n trying to update rows for====> "+rs.getString(8));
               if(row>0)
               {
               
               System.out.println(" row updated succesfully");
                 
               }
             con.commit();
             }
   if(today.equalsIgnoreCase(rs.getString("SCHEDULETWO") ) && "notsent".equalsIgnoreCase(rs.getString("SCHEDULETWOFLAG") )  )
    {
      System.out.println("Schedule Two =======>");
     String d="UPDATE hosdelivery set  REMINDERSTATUS=?, REMINDERTYPE=? ,SCHEDULEONESTATUS=?,SCHEDULEONEFLAG =? where MOTHER_REGISTRATION_ID=?";
                  FileWriter writer = new FileWriter("C:\\message\\MyFile.txt", true);
                  writer.write("Second schedule message is sent=======  semt time"+ new java.util.Date().toString());
	          writer.write("\r\n");	
                  writer.close();
                  PreparedStatement ps2=con.prepareStatement(d);
                 ps2.setString(1,"UNCONFIRMED");
                 ps2.setString(2,"DAY TWO");
                  ps2.setString(3,"sent");
                  ps2.setString(4, "sent");
                 ps2.setInt(5,rs.getInt(2)); 
                 int row=ps2.executeUpdate();
            //   System.out.println(" \n trying to update rows for====> "+rs.getString(8));
               if(row>0)
               {
               
               System.out.println(" row updated succesfully");
               
               }
       con.commit();
    }
   if(today.equalsIgnoreCase(rs.getString("SCHEDULETHREE") ) && "notsent".equalsIgnoreCase(rs.getString("SCHEDULETHREEFLAG") )  )
    {
   System.out.println("Schedule Three =======>");
  String d="UPDATE hosdelivery set  REMINDERSTATUS=?, REMINDERTYPE=? ,SCHEDULEONESTATUS=?,SCHEDULEONEFLAG =? where MOTHER_REGISTRATION_ID=?";
                  FileWriter writer = new FileWriter("C:\\message\\MyFile.txt", true);
                  writer.write("Second schedule message is sent=======  semt time"+ new java.util.Date().toString());
	          writer.write("\r\n");	
                  writer.close();
                  PreparedStatement ps2=con.prepareStatement(d);
                 ps2.setString(1,"UNCONFIRMED");
                 ps2.setString(2,"DAY THREE");
                  ps2.setString(3,"sent");
                  ps2.setString(4, "sent");
                 ps2.setInt(5,rs.getInt(2)); 
                 int row=ps2.executeUpdate();
         
               if(row>0)
               {
               
               System.out.println(" row updated succesfully");
               
               }  
                  
                   }
  
 
                }// while loop
    con.close();
    
        } catch (Exception e) {
System.out.println(e.getMessage());
        }
        

       
    }
}
