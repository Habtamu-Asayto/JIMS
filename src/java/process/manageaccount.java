package process;
import com.database.JavaUtilsEncryption;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "manageaccount")
@SessionScoped
public class manageaccount implements Serializable{
    
     FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session
            = (HttpSession) context.getExternalContext().getSession(false);
 private String email;
   private String userId;
    private String userName;
   
    private String userFatherName;
   
    private String userLastName;
  
    private String password;
   
    private String mobilePhoneNumber;
   
    private String utype;

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFatherName() {
        return userFatherName;
    }

    public void setUserFatherName(String userFatherName) {
        this.userFatherName = userFatherName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
public void process(String id)
{
    System.out.println(" inside ");

     Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
   try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:mhealth/mhealth@localhost");
           // String pwdd=JavaUtilsEncryption.generateSaltedHash(pwd, pwd);
           String sql = "select * from users where USER_ID=? ";
          //  String sql = "select * from users";
System.out.println(" try catch");

            stmt = con.prepareStatement(sql);
           stmt.setString(1,id);
           
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               //System.out.println(rs.getString("USER_ID"));
                setEmail(rs.getString("email"));
                setMobilePhoneNumber(rs.getString("MOBILE_PHONE_NUMBER"));
                setUserName(rs.getString("USER_NAME"));
                setUserFatherName(rs.getString("USER_FATHER_NAME"));
                setUserLastName(rs.getString("USER_LAST_NAME"));
                setUtype(rs.getString("U_TYPE"));
                setPassword(rs.getString("PASSWORD"));
             }

        
          rs.close();
          con.close();
           }
        catch (Exception e) {
//       context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ስህተት", "DataBase Error"));
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",e.getMessage());
FacesContext.getCurrentInstance().addMessage(null, message);
        }

}
public void update(String id)
{
    
     
    System.out.println(" inside ");

     Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
       
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:mhealth/mhealth@localhost");
           // String pwdd=JavaUtilsEncryption.generateSaltedHash(pwd, pwd);
          String d="UPDATE users set  email=?, MOBILE_PHONE_NUMBER=? ,USER_NAME=? ,USER_FATHER_NAME=?,USER_LAST_NAME=?,U_TYPE=?,PASSWORD=? where USER_ID=?";
  String pwdd=JavaUtilsEncryption.generateSaltedHash(password,password);
            stmt = con.prepareStatement(d);
            stmt.setString(1, email);
           stmt.setString(2, mobilePhoneNumber);
           stmt.setString(3, userName);
           stmt.setString(4, userFatherName);
           stmt.setString(5, userLastName);
           stmt.setString(6, utype);
           stmt.setString(7, pwdd);
           stmt.setString(8,id);
            int row=stmt.executeUpdate();
            //   System.out.println(" \n trying to update rows for====> "+rs.getString(8));
            
          //  String xy=  "<p:commandLink id='link' style=';font-size: 48px;font-weight: 300;background: aqua'  action='#{login.logout()}' value=' log in'></p:commandLink>";
               if(row>0)
               {
                session.setAttribute("infor", "your account has been changed please login again");
                 session.setAttribute("link","log-in");
              System.out.println(" row updated succesfully");
               
               }
        
          rs.close();
          con.close();
           }
        catch (Exception e) {
//       context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ስህተት", "DataBase Error"));
        }

}
}
