package process;

import com.database.JavaUtilsEncryption;
import com.database.Roles;
import com.database.RolesFacade;

import com.database.Users;
import com.database.UsersFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.chrono.GregorianChronology;

@ManagedBean(name = "Loginjustice")
@SessionScoped
public class LoginJustice implements Serializable {

    private String email;
    private String pwd;
    private boolean isLoggedin = false;
    private String loginmessage = "";
    final Logger logger = Logger.getLogger(LoginJustice.class);

    public String getLoginmessage() {
        return loginmessage;
    }

    public void setLoginmessage(String loginmessage) {
        this.loginmessage = loginmessage;
    }

    public boolean isIsLoggedin() {
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }
    private String ethiopiandate;

    public String getEthiopiandate() {
        return ethiopiandate;
    }

    public void setEthiopiandate(String ethiopiandate) {
        this.ethiopiandate = ethiopiandate;
    }

    public static String ConvertToEthiopian(int gregorianYear, int gregorianMonth, int gregorianDay) {
        Chronology chron_eth = EthiopicChronology.getInstance();
        Chronology chron_greg = GregorianChronology.getInstance();
        DateTime jodaDateTime = new DateTime(gregorianYear, gregorianMonth, gregorianDay, 0, 0, 0, chron_greg);
        DateTime dtEthiopic = jodaDateTime.withChronology(chron_eth);
        String[] monthsArray = {"meskerem", "tikimt", "hidar", "Tahsas", "Tir", "Yekatiti", "Megabit", "Miazia", "Ginbot", "sene", "Hamle", "Nehasie", "Pagume"};
        // String dateInEthiopian = dtEthiopic.getDayOfMonth()<10 ?"0"+dtEthiopic.getDayOfMonth():dtEthiopic.getDayOfMonth() + "/" + (dtEthiopic.getMonthOfYear()<10)? "0"+dtEthiopic.getMonthOfYear():dtEthiopic.getMonthOfYear()  + "/" + dtEthiopic.getYear();
        int day = dtEthiopic.getDayOfMonth();
        int mon = dtEthiopic.getMonthOfYear();
        int year = dtEthiopic.getYear();

        String builder;
        String d = day < 10 ? "0" + day : day + "";
        String m = mon < 10 ? "0" + mon : mon + "";

        return d + "/" + m + "/" + year + "";
    }
    private static final long serialVersionUID = 1L;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session
            = (HttpSession) context.getExternalContext().getSession(false);
    @EJB
    private com.database.UsersFacade usersjbFacade;

    @EJB
    private com.database.RolesFacade rolesFacade;

    public RolesFacade getRolesFacade() {
        return rolesFacade;
    }

    public void setRolesFacade(RolesFacade rolesFacade) {
        this.rolesFacade = rolesFacade;
    }

    public UsersFacade getUsersjbFacade() {
        return usersjbFacade;
    }

    public void setUsersjbFacade(UsersFacade usersjbFacade) {
        this.usersjbFacade = usersjbFacade;
    }

    public void verifyLogin() {

        if (!this.isLoggedin) {

            doRedirect("/JIMS/faces/login");
        }
    }

    public void openlogin() {
        doRedirect("/JIMS/faces/login");
    }

    public void openChangeAccount() {
        doRedirect("/JIMS/faces/manageaccount");
    }

    public void doRedirect(String url) {
        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", this.loginmessage);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (IOException ex) {

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", this.loginmessage);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    List<Roles> rolesall;

    @PostConstruct
    void init() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        rolesall = rolesFacade.findAll();
        this.ethiopiandate = ConvertToEthiopian(year, month, day);
    }

    public boolean hasRoleAdmin(List<String> role) {
        System.out.println("I will check the roles " + role);
        if (role != null) {
            if (role.contains("Admin")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
 
    public boolean hasRoleGuest(List<String> role) {
        System.out.println("I will check the roles " + role);
        if (role != null) {
            if (role.contains("Guest")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean hasRoleFrbherOfficer(List<String> role) {
        if (role.contains("Fitabherofficer")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRoleSenedochDataEncoder(List<String> role) {
        if (role.contains("SenedochDataEncoder")) {
            return true;
        } else {
            return false;
        }
    }

    private String userrole;
    private Users loggeduser;

    public Users getLoggeduser() {
        return loggeduser;
    }

    public void setLoggeduser(Users loggeduser) {
        this.loggeduser = loggeduser;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
    private List<Roles> roless = new ArrayList<Roles>();

    public List<Roles> getRoless() {
        return roless;
    }

    public void setRoless(List<Roles> roless) {
        this.roless = roless;
    }

    public void guestLogin() {  
       doRedirect("dashboard");
    }

    public void proceslogin() throws IOException {
        int x = 0;

        String uname = null;
        int id;
        Users u = null; 
        String pwdd = JavaUtilsEncryption.generateSaltedHash(pwd.trim(), pwd.trim());
        //logged= (Users) em.createQuery("SELECT u FROM Users u WHERE lower(u.username) = :username and u.password = :password"  ).setParameter("username",lowerusername).setParameter("password",pwd).getSingleResult();
        try {

            u = getUsersjbFacade().findLogeduserfitih(email.trim(), pwdd);

            if (u != null) {

                x = 1;
                this.loggeduser = u;
                uname = u.getFirtstname() + u.getMiddlename();
                id = u.getId();
                this.roless = u.getRole();

                if (x == 1) {
                    session.setAttribute("user", uname);
                    this.isLoggedin = true;
                    System.out.println("The next is logger call " + u.getFirtstname());
                    logger.info("The user " + u.getFirtstname() + " is logged with email " + this.email + " and role ===> " + this.roless);

// FacesContext.getCurrentInstance().getExternalContext().redirect("/TeleRadiology/faces/template");
                    doRedirect("dashboard");

                }
            } else {
                this.loginmessage = "There is Error in the Login please verify your account ";
            }

        } catch (Exception e) {
            if (e.getMessage() == null) {
                System.out.println("There is Some Error ");
                this.loginmessage = "There is Error in the Login ";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "There is Error in the login" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void clear() throws IOException {
        setEmail("");
        setPwd("");

    }

    public void logout() throws IOException {
        //logger.debug("The user "+this.loggeduser.getFirtstname()+" is logged  out with email "+this.email + " and role ===> "+this.roless);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/JIMS-master/faces/login");
        //  return "/faces/login.xhtml";

    }

    public String redirect() throws IOException {

        clear();

        return "/faces/changepassword";

    }

}
