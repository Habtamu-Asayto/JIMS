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
public class MessageProcess implements Serializable {

    Connection con;
    ResultSet rs;

    public void action() {
        try {
            
       
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:mhealth/mhealth@localhost");
            //    String sql = "SELECT * FROM PREGNANCY";
               String sql = "SELECT * FROM pregnancy where Status=? ";
               PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, "Delivered");
                 rs=ps.executeQuery();
                 
             java.util.Date tod= new java.util.Date();
            DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT);
            String today=df.format(tod);
      
		
                while (rs.next()) {
    //System.out.println("=name  =====   "+rs.getString(8)+"id is"+ rs.getInt(2) + today+"  the first day is   "+rs.getString(18));	
              
    if(today.equalsIgnoreCase(rs.getString(18) ) && !(rs.getInt(24)==1)  )
            {
    System.out.println("Schedule one =======>get equl for the id" + rs.getInt(2));
         //fd1=1;
         
          String d="UPDATE pregnancy set  REMINDER_STATUS=?, REMINDER_TYPE=? ,DAY1FLAG=? where MOTHER_REGISTRATION_NUMBER=?";
                  FileWriter writer = new FileWriter("C:\\message\\MyFile.txt", true);
                  writer.write("Welcome "+ rs.getString(8) + " Send Message  "+ "for "+rs.getString(18)+"=======  semt time"+ new java.util.Date().toString());
	          writer.write("\r\n");	
                  writer.close();
                PreparedStatement ps2=con.prepareStatement(d);
                 ps2.setString(1,"UNCONFIRMED");
                 ps2.setString(2,"DAY ONE");
                  ps2.setInt(3,1);
                 ps2.setInt(4,rs.getInt(2)); 
                 int row=ps2.executeUpdate();
            //   System.out.println(" \n trying to update rows for====> "+rs.getString(8));
               if(row>0)
               {
               
               System.out.println(" row updated succesfully");
               
               }
                        
             
            
             }
     if(today.equalsIgnoreCase(rs.getString(19))&& !(rs.getInt(23)==1))
    {
      System.out.println("Schedule Two =======>");
      String d="UPDATE pregnancy set  REMINDER_STATUS=?, REMINDER_TYPE=? ,DAY2FLAG=? where MOTHER_REGISTRATION_NUMBER=?";
                  FileWriter writer = new FileWriter("C:\\message\\MyFile.txt", true);
                  writer.write("Second schedule message is sent=======  semt time"+ new java.util.Date().toString());
	          writer.write("\r\n");	
                  writer.close();
                  PreparedStatement ps2=con.prepareStatement(d);
                 ps2.setString(1,"UNCONFIRMED");
                 ps2.setString(2,"DAY TWO");
                  ps2.setInt(3,1);
                 ps2.setInt(4,rs.getInt(2)); 
                 int row=ps2.executeUpdate();
            //   System.out.println(" \n trying to update rows for====> "+rs.getString(8));
               if(row>0)
               {
               
               System.out.println(" row updated succesfully");
               
               }
      
    }
   if(today.equalsIgnoreCase(rs.getString(20) ) && !(rs.getInt(24)==1))
    {
   System.out.println("Schedule Two =======>");
      String d="UPDATE pregnancy set  REMINDER_STATUS=?, REMINDER_TYPE=? ,DAY3FLAG=? where MOTHER_REGISTRATION_NUMBER=?";
                  FileWriter writer = new FileWriter("C:\\message\\MyFile.txt", true);
                  writer.write("Second schedule message is sent=======  semt time"+ new java.util.Date().toString());
	          writer.write("\r\n");	
                  writer.close();
                  PreparedStatement ps2=con.prepareStatement(d);
                 ps2.setString(1,"UNCONFIRMED");
                 ps2.setString(2,"DAY THREE");
                  ps2.setInt(3,1);
                 ps2.setInt(4,rs.getInt(2)); 
                 int row=ps2.executeUpdate();
         
               if(row>0)
               {
               
               System.out.println(" row updated succesfully");
               
               }     
                   }
 
                }

        } catch (Exception e) {
System.out.println(e.getMessage());
        }
        

       
    }
}
