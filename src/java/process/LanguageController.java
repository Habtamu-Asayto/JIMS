/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;   
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext; 
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
 
@Named(value = "languageController")
@SessionScoped
public class LanguageController implements Serializable{
    private String language="en"; 
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    
    //Change Language using drop down 
    private String lang;
    private Map<String, String> allLanguages;
    
     /**
     * Creates a new instance of LanguageController
     */
    public LanguageController() {
    }
    
    @PostConstruct
    public void init(){  
        language="en";
        allLanguages = new HashMap<>();
        allLanguages.put("English", "en");
        allLanguages.put("Amharic", "am"); 
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.err.println("Fail to load JDBC driver");
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/success", "postgres", "root");
            System.out.println("=======================Connected========================");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
      
    public void actionEnglish(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
        language="en"; 
        
        session.setAttribute("language", language);
    }
    public void actionAmharic(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("am"));
        language="am";  
        session.setAttribute("language", language);
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Map<String, String> getAllLanguages() {
        return allLanguages;
    }

    public void setAllLanguages(Map<String, String> allLanguages) {
        this.allLanguages = allLanguages;
    }   
    public void finishChange(String language){
        if(language.equalsIgnoreCase("am")){
            actionAmharic();
        }
        else if(language.equalsIgnoreCase("en")){
            actionEnglish();
        }
    }
}
