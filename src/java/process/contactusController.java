package process;
import com.database.JavaUtilsEncryption;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@ManagedBean(name = "contactus")
@RequestScoped
public class contactusController implements Serializable {
    String name;
 FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session
            = (HttpSession) context.getExternalContext().getSession(false);
   
     String emalil;
     String message;
     String contactusid;
     String  mname;
     String  phone;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
     String lname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
     String cid;
    public HttpSession getSession() {
        return session;
    }
  public void setSession(HttpSession session) {
        this.session = session;
    }

   

    public String getEmalil() {
        return emalil;
    }

    public void setEmalil(String emalil) {
        this.emalil = emalil;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void  contactusProcess() {
     
    Connection con = null;
        PreparedStatement stmt = null;
        int rs;
        int x = 0;
     
           
               try {
            Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Tdmj6qUX3pdTzvxr");///uogcs@localhost");
 String sql="insert into uogexambank.contact_us(FirtstName,MiddleName,LastName,messege,phone,email) values(?,?,?,?,?,?)";
       stmt = con.prepareStatement(sql);
             stmt.setString(1,name );
             stmt.setString(2,mname);
             stmt.setString(3,lname);
              stmt.setString(4,message );
               stmt.setString(5,phone );
             stmt.setString(6, emalil);
               
           rs = stmt.executeUpdate();
             if(rs>0)
             {
                 x=1;
         //
             }
       
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));

        }

        if (x == 1) {
        //   session.setAttribute("kesahname", kesahname);
          //  session.setAttribute("tekesashname", tekesashname);
            clear();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succuss", "Your Inforamtion IS successfully Send"));
            
        } else {

    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Invalid File Number or Name"));
           
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void clear()
    {
    
     this.setName("");
    this.setCid("");
    this.setMessage("");
    this.setEmalil("");
    this.setMname("");
    this.setPhone("");
    this.setLname("");
    
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public  void logout() throws ClassNotFoundException, SQLException {
   
}
}
 