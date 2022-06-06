/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;

@ManagedBean(name = "filedownloads")
public class FileDownloadView  implements Serializable{
      
    private  String todowloadfilepath;

    public String getTodowloadfilepath() {
        return todowloadfilepath;
    }
 public void check()
 {
 
 System.out.println(" checking the path");
 }
    public void setTodowloadfilepath(String todowloadfilepath) {
        this.todowloadfilepath = todowloadfilepath;
        
      
    }
    private StreamedContent file;
     
    public FileDownloadView() {        
      InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/1.jpg");
      //  InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(todowloadfilepath);
      //  file = new DefaultStreamedContent(stream, "image/jpg", todowloadfilepath);
    }
  public void Download() throws FileNotFoundException {    
    String ext1 = FilenameUtils.getExtension(todowloadfilepath);
   
   

   InputStream stream = new FileInputStream ( new File(todowloadfilepath));
 
   if(ext1.equalsIgnoreCase("pdf")) {      
//file = new DefaultStreamedContent(stream, "file/pdf", todowloadfilepath);}

       
      
    }

  
  }
    public StreamedContent getFile() {
        return file;
    }
    public void fileuploadpath(String path) throws IOException
    {
       
        setTodowloadfilepath(path);
        try {
            Download();
        } catch (FileNotFoundException ex) {
          System.out.println(ex.getMessage());
        }
    }
    
  
   public void backupdata()
   {
   String pathh="D://WoredaFitih//Backup//BACKUPF.DMP";
   setTodowloadfilepath(pathh);
        try {
            Download();
        } catch (FileNotFoundException ex) {
          System.out.println(ex.getMessage());
        }
   }
   public void openFile( String path ) throws FileNotFoundException, IOException {
       File file= new File(path);
FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
System.out.println(" this is file path "+file.getAbsolutePath());
        try {
            // Open file.
            input = new BufferedInputStream(new FileInputStream(file), 10240);

            // Init servlet response.
            response.reset();
            // lire un fichier pdf
            response.setHeader("Content-type", "application/pdf"); 
            response.setContentLength((int)file.length());

            response.setHeader("Content-disposition", "inline; filename=" + file.getAbsolutePath());
            response.setHeader("pragma", "public");
            output = new BufferedOutputStream(response.getOutputStream(), 10240);

            // Write file contents to response.
            byte[] buffer = new byte[10240];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            // Finalize task.
            output.flush();
        } finally {
            // Gently close streams.

                output.close();
                input.close();
        }
}
   
}
