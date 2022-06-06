/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "moreless")
@SessionScoped
public class newscontrolmoreless implements Serializable{
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session
            = (HttpSession) context.getExternalContext().getSession(false); 
     public void processnewsshow(String check)
    {
        
       System.out.println(" check is comeing"+check);
          session.setAttribute(check,"hey gonna fin ");
          
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error"+check, "session created");
            FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
