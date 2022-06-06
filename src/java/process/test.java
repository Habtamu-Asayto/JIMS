
package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;

public class test {
 Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

    public static void main(String arg[]) throws ClassNotFoundException{
     new test().action();
    }
    public void action(){   
   
            try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:mhealth/mhealth@localhost");

            String sql = "select * from users where user_name=?";//  and  PASSWORD =?  ";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, "Fedlu");
           // stmt.setString(2, "1234");
           
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getString(4));
            }
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());
        }
    }}
