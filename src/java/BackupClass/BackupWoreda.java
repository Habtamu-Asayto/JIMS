/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackupClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;



@ManagedBean
@SessionScoped

public class BackupWoreda implements Serializable{
    	
public static final String EXPORT_DIR = "D:\\WoredaFitih\\Backup";

private Integer progress;
private Integer progressIm;
private boolean progCom = false;
private boolean progComIm = false;
private boolean startEp = false;
private boolean StartIm = false;


public void export() 
            throws SQLException, IOException, ClassNotFoundException {
    startEp = true;
    

    Connection con = null;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con = DriverManager.getConnection("jdbc:oracle:thin:woredafitih/weredafitihuog@localhost");
    
  String sql = getFileContents("export.sql");

    PreparedStatement pStmt = con.prepareStatement(sql);
  System.out.println("Conection is established"+con.toString());
  pStmt.setString(1, "woredafitih".toUpperCase());
  pStmt.setString(2, EXPORT_DIR);
  pStmt.setString(3, "BACKUPF");
  try{
  pStmt.execute();
  System.out.println("After execution");
  }catch(Exception e){
  System.out.println(" the error is "+e.getMessage());
  }
  progCom = true;

}
 
public void importf() 
        
            throws IOException, SQLException, ClassNotFoundException {
    StartIm = true;


    String schema = "woredafitih";
    String fileName = "BACKUPF";
     Connection con = null;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con = DriverManager.getConnection("jdbc:oracle:thin:woredafitih/weredafitihuog@localhost");

  String sql = getFileContents("import.sql");
  PreparedStatement pStmt = con.prepareStatement(sql);
  pStmt.setString(1, schema.toUpperCase());
  pStmt.setString(2, EXPORT_DIR);
  pStmt.setString(3, fileName);
  pStmt.execute();
  progComIm = true;
      
 }
 
private String getFileContents(String fileName) 
               throws IOException {
  InputStream in = this.getClass()
                   .getResourceAsStream(fileName);
  return IOUtils.toString(in, "UTF-8");
}

    public Integer getProgress() {
        if(startEp == false) {
            progress = 0;
        }
        else {
            progress = progress + (int)(Math.random() * 35);
             
            if(progCom == true){
            
                progress = 100;
                startEp = false;
            
            }
                
        }
         
        return progress;
    }
 
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getProgressIm() {
        if(StartIm == false) {
            progressIm = 0;
        }
        else {
            progressIm = progressIm + (int)(Math.random() * 35);
             
            if(progComIm == true){
                
                progressIm = 100;
                StartIm = false;
                
            }
                
        }
         
        return progressIm;
    }

    public void setProgressIm(Integer progressIm) {
        this.progressIm = progressIm;
    }
     
    
    
    public void onComplete() {
        if ( progCom == true ){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "successful", "Backup Taken Successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }  
    }
    
    public void onCompleteIm() {
        if ( progComIm == true ){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "successful", "Database Recovered Successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }  
    }
     
    public void cancel() {
        progress = null;
    }
   
}


