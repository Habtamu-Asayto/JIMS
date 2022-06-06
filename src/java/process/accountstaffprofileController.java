package process;

import com.database.JavaUtilsEncryption;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "staffprofileaccountcontroller")
@RequestScoped
public class accountstaffprofileController implements Serializable {
    String firstName;
    String middleName;
    String lastName;
     String userName;
    String email;
    String password;
    String sex;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
  String confirmpassword;
    String userId;
    String username;
    String privilege;
    String oldpassword;

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }
   
    String colleage;
    String department;
   java.util.Date regDate;
   
 Connection con = null;
 PreparedStatement stmt = null;
 ResultSet rs = null;
    public java.util.Date getRegDate() {
        return regDate;
    }

    public void setRegDate(java.util.Date regDate) {
           java.util.Date now=new java.util.Date();
      /* DateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        java.util.Date dTemp = null;
        dTemp = formatter.parse(now.toString());
      formatter = new SimpleDateFormat("dd- MMM-yyyy");
       String ethdate = formatter.format(dTemp);
               //setSubmissionDate(ethdate); */
        this.regDate = now;
        
    }
   
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

   
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session
            = (HttpSession) context.getExternalContext().getSession(false);

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public void createuser() throws IOException {

      int x=0;
      String mess="";
        privilege="customer";
       try {
            Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Tdmj6qUX3pdTzvxr");///uogcs@localhost");
  String pwdd=JavaUtilsEncryption.generateSaltedHash(password, password);
  String confirmpass=JavaUtilsEncryption.generateSaltedHash(confirmpassword, confirmpassword);
         /*  String sql1 = "select * from uogstaffprofile.user.user";
             ResultSet rsss=stmt.executeQuery(sql1);
           while(rsss.next())
           {
           System.out.println(rsss.getString("uname"));
           }
           */
       System.out.println("now im able to create user");
  //String sql="insert into usersaccount(PHOL_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,USER_NAME,EMAIL,PASSWORD,CONFIRMPASSWORD,USER_ID) values(useracc_seq.nextVal,?,?,?,?,?,?,?,?)";
String sql="insert into uogstaffprofile.user(name,mname,lname,colleges,departments,email,role,upassword,sex,status) values(?,?,?,?,?,?,?,?,?,?)";
           //,reg_date
            stmt = con.prepareStatement(sql);
            stmt.setString(1,firstName);
            stmt.setString(2, middleName);
            stmt.setString(3,lastName);
            stmt.setString(4,colleage);
            stmt.setString(5, department);
            stmt.setString(6,email);
            stmt.setString(7,privilege);
            stmt.setString(8, pwdd);
            stmt.setString(9, sex);
            stmt.setString(10, "Enable") ;
            
           System.out.println(" inside create user result set executed with "+firstName +" "+middleName+" "+lastName +" "+colleage +" "+
                   department+" "+email+" "+privilege+" "+password+"  "+sex);
          int  rss = stmt.executeUpdate();
            
            if(rss>0) {
            
               x=1; 
                 System.out.println(" succesfull ");
            }
            else{
            x=0;
            }
            
        
con.close();
        }
         
         catch (ClassNotFoundException | NumberFormatException | SQLException e) {
              System.out.println("Error is "+e.getMessage());
          mess=e.getMessage();
          if(e.getMessage()!=null)
              x=0;
       }

        if (x==1){
             mess="Your account hass been sucesfully created ";
        session.setAttribute("infor", "your account has been created  please login again");
        session.setAttribute("link","log-in");
    
    
     
        }  
        if(x==0)  {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected",mess );
FacesContext.getCurrentInstance().addMessage(null, message);
  }
    }

    public String getColleage() {
        return colleage;
    }

    public void setColleage(String colleage) {
        this.colleage = colleage;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @PostConstruct
    public void  init()
    {
 setOldpassword("");
    clear();
    }
    public void clear()
    {
         firstName="";
         middleName="";
         lastName="";
         userId="";
         userName="";
         password="";
         oldpassword="";
         confirmpassword="";
    }

    public String getOtherOffice_name() {
        return otherOffice_name;
    }

    public void setOtherOffice_name(String otherOffice_name) {
        this.otherOffice_name = otherOffice_name;
    }
    String otherOffice_name;
    public void logout() throws IOException{

       
        session.invalidate();
       FacesContext.getCurrentInstance().getExternalContext().redirect("/UOGESD/faces/login.xhtml");
     // return "/faces/login.xhtml";
         
    }
   public void process(String id)
{
  
  int x=Integer.parseInt(id);
     Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
     //  insert into usersaccount(PHOL_ID,FIRST_NAME,,LAST_NAME,USER_NAME,,PASSWORD,CONFIRMPASSWORD,USER_ID) values(useracc_seq.nextVal,?,?,?,?,?,?,?,?)";
   try {
              Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Tdmj6qUX3pdTzvxr");///uogcs@localhost");
  String pwdd=JavaUtilsEncryption.generateSaltedHash(oldpassword, oldpassword);
           String sql = "select password,passwordverify,previlege from pediatricsuog.users where id=?  ";
           stmt = con.prepareStatement(sql);
           stmt.setInt(1,x);
            rs = stmt.executeQuery();
            int flag=0;
            while (rs.next()) {
                if(rs.getString("PASSWORD").equalsIgnoreCase(pwdd)) 
                    {
                     String prev=rs.getString("previlege");
                     update(password,confirmpassword,x,prev);
                     flag=1;
                }
                
             }
  if(flag==0)
  {
 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error","Incorrect old password is given!" );
FacesContext.getCurrentInstance().addMessage(null, message);
  }
          rs.close();
          con.close();
           }
        catch (Exception e) {
            if(e.getMessage()!=null){
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected",e.getMessage() );
FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }

}
public void update(String password,String confirm,int idd,String prev) throws ClassNotFoundException, SQLException
{
    try {
         
             Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Tdmj6qUX3pdTzvxr");
                      
     String sql="update pediatricsuog.users set password=?,passwordverify=?,previlege=? where ID=?"; 
     String pwdd=JavaUtilsEncryption.generateSaltedHash(password, password);
      String confirmpass=JavaUtilsEncryption.generateSaltedHash(confirm, confirm);
           stmt = con.prepareStatement(sql);
            stmt.setString(1,pwdd);
            stmt.setString(2, confirmpass);
            stmt.setString(3,prev);
            stmt.setInt(4, idd);
            int row=stmt.executeUpdate();
         if(row>0)
               {
              session.setAttribute("infor", "your account has been changed please login again");

              }
        
          rs.close();
          con.close();
          clear();
           }
        catch (Exception e) {
             if(e.getMessage()!=null){
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected",e.getMessage() );
FacesContext.getCurrentInstance().addMessage(null, message);
             }
        }

}
   
    }
 