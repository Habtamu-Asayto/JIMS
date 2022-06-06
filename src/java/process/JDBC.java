
package process;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC {
   public static void main(String arg[]) throws ClassNotFoundException, SQLException
   {
       
       try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
     System.out.println("class is loaded");
    // Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mhealth","mhealth");

       String x="topSecretPassword";
     String sql1="update users set password = lower(DBMS_OBFUSCATION_TOOLKIT.md5 (input => UTL_RAW.cast_to_raw('topSecretPassword'))) where user_name='Sumi'";
     String sql="select * from users where PASSWORD =lower(DBMS_OBFUSCATION_TOOLKIT.md5 (input => UTL_RAW.cast_to_raw(?)))";  
     
     PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, x);
     
         
           
         ResultSet   rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getString("user_name")+"   =====   "+rs.getString("PASSWORD"));
            }
     /*
     PreparedStatement ps = con.prepareStatement(sql);
      //      ps.setString(1, "Live");
           int  rs = ps.executeUpdate();
  if(rs>0)
          {
          System.out.println(" succesfully updated!");
          }
       
            */
       }
       catch(Exception e)
       {
       
       System.out.println(e.getMessage());
       
       }
   
   }
}
