/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import com.database.JavaUtilsEncryption;
import com.database.Users;
import com.database.UsersFacade;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fedlu
 */
@ManagedBean(name = "SettingBean")
@SessionScoped
public  class Setting {
    @EJB
    private com.database.UsersFacade usersjbFacade;
  
  
 public void processSettingStatus() {

 

}
// public String processtoday() throws ParseException{
//  
//     
//  
//   }

    public UsersFacade getUsersjbFacade() {
        return usersjbFacade;
    }

    public void setUsersjbFacade(UsersFacade usersjbFacade) {
        this.usersjbFacade = usersjbFacade;
    }

    
  
 @PostConstruct
public void init() 
{
    List<Users>all=getUsersjbFacade().findAll();
  processSettingStatus();
  
}
}
