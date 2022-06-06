package process;

import com.database.JavaUtilsEncryption;
import java.io.IOException;
import java.sql.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import javax.mail.MessagingException;
@ManagedBean(name = "passwordreset")
@RequestScoped
public class changepassword implements Serializable {
        String email;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int x = 0;
        String emailto=null;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
     String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
  
   
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session
            = (HttpSession) context.getExternalContext().getSession(false);
 public void  check() {
      
  try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:uogcs/uogcs@localhost");
          // String sql = "select * from users where NAME=? and email=?   and  PASSWORD =? and PREVILAGE=? ";
          String sql = "select * from users where emain=? and username=?";
          // String sql = "select * from users where EMAIL=? ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, username);
            rs = stmt.executeQuery();
            int flag=0;
           System.out.println(" hey inside check");
   while (rs.next()) {
        emailto=rs.getString("EMAIN");
        
          flag=1;
                 }
   if(flag==1){
      sendMail(); 
   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error","try to send email................");
FacesContext.getCurrentInstance().addMessage(null, message);
   }
   if(flag==0)
   {
     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error","please provide correct email / username");
FacesContext.getCurrentInstance().addMessage(null, message);
   }
   rs.close();
  stmt.close();
  con.close();
        } 
  catch (Exception e) {
 
     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error","Error occured while trying to send password reset");
FacesContext.getCurrentInstance().addMessage(null, message);
             }
   
            }
    public void clear()
            {
                 
   
               }
public String logout() throws IOException {

      
        session.invalidate();
        
       return "/faces/login.xhtml";
     
        
    }
  public String  redirect() throws IOException{
 //FacesContext.getCurrentInstance().getExternalContext().redirect("/commuinityservice/faces/changepassword.xhtml");
return "/changepassword.xhtml";
 
}

 public void sendMail() throws MessagingException {
  String x=null;
  
GmailSmtpSSL gs=  new GmailSmtpSSL("uogmhealth@gmail.com", "mhealth@1234");
Randomtext rt= new Randomtext();
String generatedtext=rt.generaterandom();
  
 try {
     System.out.println("password resetted  succesfully inside email sending  rty  ");
        gs.sendMailTo(emailto,"password reset code","please use this code and don't forget to rechange your password \n"+generatedtext );
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:uogcs/uogcs@localhost");
      String d="UPDATE users set  password=? ,CONFIRMPASSWORD=?  where emain=? and username=?";
           stmt = con.prepareStatement(d);
            String pwdd=JavaUtilsEncryption.generateSaltedHash(generatedtext, generatedtext);
              System.out.println("password resetted  succesfully inside email sending !!!!!");
            stmt.setString(1, pwdd);
            stmt.setString(2,pwdd);
            stmt.setString(3, email);
            stmt.setString(4, username);
            int row=stmt.executeUpdate();
                
                 if(row>0)
                    {
                    System.out.println("password resetted  succesfully");
      x= "/faces/confirmpasswordchange.xhtml"; 
  FacesContext.getCurrentInstance().getExternalContext().redirect("/commuinityservice/faces/confirmpasswordchange.xhtml");
                 }
                 else
                 {
       x="false";
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "unable to update the account"));          
                 }
                 
      stmt.close();
 con.close();             
   }

   catch(Exception e){
   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",e.getMessage() );
FacesContext.getCurrentInstance().addMessage(null, message);
   }
          
   //  return x; 
 }
 public void test()
 {
 System.out.println(" hey this is testing");
 }
}
 