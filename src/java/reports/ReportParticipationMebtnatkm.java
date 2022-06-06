package reports;

import com.database.Mebtnatkmmyefetabherafetatem;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Calendar;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;


import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset; 
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.chrono.GregorianChronology;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped

public class ReportParticipationMebtnatkm implements Serializable {
    String year;

    public String[] getdatesgenerated() {
        return datesgenerated;
    }

    public void setdatesgenerated(String[] datesgenerated) {
        this.datesgenerated = datesgenerated;
    }
    private BarChartModel barModel;
      private BarChartModel barModemalefemale;
    //  private BarChartModel barModelbasedonleve;
    private PieChartModel pieModel1;
    private PieChartModel pieModelforfinaloutcome;
   
    private String []datesgenerated;
   private int []daystotal;  
   public String []catagorytypes;

   


    public BarChartModel getBarModemalefemale() {
        return barModemalefemale;
    }

    public void setBarModemalefemale(BarChartModel barModemalefemale) {
        this.barModemalefemale = barModemalefemale;
    }
 int[][] Mebtnatkmmyefetabherafetatemcatagory;
 int [][]malefemale;
 
         String []catagory={"በድርድር","በክርክር እና ውሳኔ"};   
         
         private List<Mebtnatkmmyefetabherafetatem> allMebtnatkmmyefetabherafetatem;
         
    @EJB
    private com.database.MebtnatkmmyefetabherafetatemFacade ejbFacade;

    public List<Mebtnatkmmyefetabherafetatem> getallMebtnatkmmyefetabherafetatem() {
        return allMebtnatkmmyefetabherafetatem;
    }

    public void setallMebtnatkmmyefetabherafetatem(List<Mebtnatkmmyefetabherafetatem> allMebtnatkmmyefetabherafetatem) {
        this.allMebtnatkmmyefetabherafetatem = allMebtnatkmmyefetabherafetatem;
    }
      
    public String  numberofdaytocomeback;

    public String getNumberofdaytocomeback() {
        return numberofdaytocomeback;
    }

    public void setNumberofdaytocomeback(String numberofdaytocomeback) {
        this.numberofdaytocomeback = numberofdaytocomeback;
    }
 
    @PostConstruct
    public void init() {
        System.out.println(" Total size for facade" );
        allMebtnatkmmyefetabherafetatem=ejbFacade.findAll();
         numberofdaytocomeback=-10+"";
           
         System.out.println(" Total size for facade"+ejbFacade.count() );
          
       generateDays(numberofdaytocomeback);

       
        
    }
    public void generateDays(String numberofdaytocomeback)
    {
        System.out.println("Inside generated Days");
        int x=Integer.parseInt(numberofdaytocomeback)+1;
         int n=Math.abs(x);
         
          System.out.println("This is generated for size absolute  "+n+" and incoming==> "+x);
     int j=0;
     datesgenerated= new String[n+1];
for(int i=x;i<=0;i++)
{
Calendar calendar =Calendar.getInstance(); 
calendar.add(Calendar.DATE, i);

int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH)+1;
int day = calendar.get(Calendar.DAY_OF_MONTH);
  String ethiopiandate= ConvertToEthiopian(year, month, day);
//System.out.println(i+" yes wel done this is calnader===> "+day+"--"+month+"--"+year+"===>"+ethiopiandate);
 datesgenerated[j]=ethiopiandate;

 
 j++;
}
    catagorytypes=new String[catagory.length];
         int k=0;
          for(String coll:catagory)
         {
          catagorytypes[k]=coll;
          k++;
         }
    setYear(2012+"");
        process_modeOf_delivery_by_year(year);
        
    }
 public static String ConvertToEthiopian( int gregorianYear, int gregorianMonth, int gregorianDay) {
    Chronology chron_eth = EthiopicChronology.getInstance();
    Chronology chron_greg = GregorianChronology.getInstance();
    DateTime jodaDateTime = new DateTime(gregorianYear, gregorianMonth, gregorianDay, 0, 0, 0, chron_greg);
    DateTime dtEthiopic = jodaDateTime.withChronology(chron_eth);
    String[] monthsArray = {"meskerem","tikimt","hidar","Tahsas","Tir","Yekatiti","Megabit","Miazia","Ginbot","sene","Hamle","Nehasie","Pagume"};
   
// String dateInEthiopian = dtEthiopic.getDayOfMonth()<10 ?"0"+dtEthiopic.getDayOfMonth():dtEthiopic.getDayOfMonth() + "/" + (dtEthiopic.getMonthOfYear()<10)? "0"+dtEthiopic.getMonthOfYear():dtEthiopic.getMonthOfYear()  + "/" + dtEthiopic.getYear();
    int day=dtEthiopic.getDayOfMonth();
    int mon=dtEthiopic.getMonthOfYear();
    
   
    int year=dtEthiopic.getYear();
    String builder;
    String d=day<10? "0"+day:day+"";
    String m=mon<10? "0"+mon:mon+"";
          
    
    return d+"/"+ m+"/"+year+"";
}
    public BarChartModel getBarModel() {
        System.out.println("get Bar Modlel ===> ");
        return barModel;
    }
     
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    private void createBarModels() throws ClassNotFoundException, SQLException {
        createBarModel();
       createPieModel1();
        createPieModelforfinaloutcome();
      
    }
     
    private void createBarModel() throws ClassNotFoundException, SQLException {
       barModel = initBarModel();
       barModemalefemale=initBarModel2();
      // barModelbasedonleve=initBarModel3();
       
       
        barModel.setTitle("መብት እና ጥቅም ማስጠበቅ መሰረታዊ የስራ ሂደት የፍታብሄር አፈፃፀም አጠቃላይ የተዘጉ ፋይሎች   =>"+year);
        barModel.setLegendPosition("ne");
        /// setting for male female participation
        Axis xAxis = barModel.getAxis(AxisType.X);
       System.out.println("Bar model Set up is done here ");
        xAxis.setLabel("Dates");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("አጠቃላይ ድምር");
        yAxis.setMin(0);
        yAxis.setMax(10);
        /////female male 
          barModemalefemale.setTitle("መብት እና ጥቅም ማስጠበቅ መሰረታዊ የስራ ሂደት የፍታብሄር አፈፃፀም ፋይል የተከፈቱና የተዘጉ ፋይሎች  "+year);
          
        //   barModelbasedonleve.setTitle("Follow Up Outcome For Admitted Patients  for the Year"+year);
          barModemalefemale.setLegendPosition("ne");
       //   barModelbasedonleve.setLegendPosition("ne");
          
          Axis xAxismalefemale = barModemalefemale.getAxis(AxisType.X);
        xAxismalefemale.setLabel("ቀናቶች");
         xAxismalefemale.setTickAngle(-70);
         
        Axis yAxismalefemale = barModemalefemale.getAxis(AxisType.Y);
        yAxismalefemale.setLabel("አጠቃላይ ድምር ");
       yAxismalefemale.setMin(0);
        yAxismalefemale.setMax(10);
        
        
        /*
         Axis xAxismalefemalelevel = barModelbasedonleve.getAxis(AxisType.X);
        xAxismalefemalelevel.setLabel("Dates genrated ");
         xAxismalefemalelevel.setTickAngle(-70);
         
        Axis yAxismalefemalelevel = barModelbasedonleve.getAxis(AxisType.Y);
        yAxismalefemalelevel.setLabel("Total Mebtnatkmmyefetabherafetatem");
       yAxismalefemalelevel.setMin(0);
        yAxismalefemalelevel.setMax(30);
        */
       System.out.println("Set up is some how finied title and other"); 
        
        
        
    }
     
    private BarChartModel initBarModel() throws ClassNotFoundException, SQLException {
         System.out.println("Inside  initBar Model ====> 2"+datesgenerated.length+" and ===>"+catagorytypes.length);
        BarChartModel model = new BarChartModel();
       // BarChartModel modelfemalemale=new BarChartModel();
         
        daystotal= new int[datesgenerated.length];
        Mebtnatkmmyefetabherafetatemcatagory   =new int[datesgenerated.length][catagorytypes.length];
                             int[] males =new int[datesgenerated.length];
                             int[] females =new int[datesgenerated.length];
                           //  System.out.println("after initializing Models other====>");
                     //  System.out.println("Mebtnatkmmyefetabherafetatem data ====> 4"+daystotal.length);      
                             try
        {
			   for(Mebtnatkmmyefetabherafetatem dr :allMebtnatkmmyefetabherafetatem )   
                               
     {
         // System.out.println("Mebtnatkmmyefetabherafetatem data ====> 3"+dr.getDateofarrival()); 
     String dataedata[]=dr.getMezgebuyetewesenebetken().split("/");
   
  //    System.out.println("######### this is array of data "+dataedata[2]);
  if(year.equalsIgnoreCase( dataedata[2])){
               System.out.println("There is Year Generation===>"+dataedata[2]);
                             for(int i=0;i<datesgenerated.length;i++){
                              if(datesgenerated[i].equalsIgnoreCase(dr.getMezgebuyetewesenebetken())){
                                
                                  for(int j=0;j<catagorytypes.length;j++){
                                      
                                   if(dr.getGudayuyalekebethuneta().equalsIgnoreCase(catagorytypes[j]))
                                                  {
                                       System.out.println("date ===>"+dataedata[2]+"how file is closed"+dr.getYefayluaynet());                 
                                       Mebtnatkmmyefetabherafetatemcatagory[i][j]=Mebtnatkmmyefetabherafetatemcatagory[i][j]+1;                                      
                                                   }
                                                }    
                                   
                          
                          daystotal[i]= daystotal[i] + 1; //caclulating total Mebtnatkmmyefetabherafetatem for each colleage
                       
                                   
                              }// ifcaluse
                              
                              
                             } // fro close
                        } // while loop
                       
                       
                         }
        }//try
               
                  catch (Exception ex) {
			                   System.out.println("===>Error generated"+ex.getMessage());
		}
     
        
          ChartSeries projecttypesseries[];
       projecttypesseries= new ChartSeries[catagorytypes.length];
      
        for(int i=0;i<projecttypesseries.length;i++){
           projecttypesseries[i]=new ChartSeries(catagorytypes[i]);
        }
          
   System.out.println(" we have three serieses ====" +projecttypesseries.length);
 
      for(int i=0;i<daystotal.length;i++){
   
   for(int j=0;j<catagorytypes.length;j++)
                              {
                                  
   projecttypesseries[j].set(datesgenerated[i], Mebtnatkmmyefetabherafetatemcatagory[i][j] );
                    
                                         } 
                           
                              }
      
     // setting the models
      for(int i=0;i<projecttypesseries.length;i++)    {
     model.addSeries(projecttypesseries[i]);
    }
      
     // System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Model one is finished");
       return   model;
    }
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         for(int k=0;k<datesgenerated.length;k++)
         {
             System.out.println("May be Some thing"+k +" => "+datesgenerated[k]);
         pieModel1.set(datesgenerated[k] +"="+daystotal[k] , daystotal[k]);
        }
        pieModel1.setTitle("መብት እና ጥቅም ማስጠበቅ መሰረታዊ የስራ ሂደት የፍታብሄር አፈፃፀም አጠቃላይ የተዘጉ ፋይሎች =>"+year);
        pieModel1.setLegendPosition("w");
        pieModel1.setMouseoverHighlight(true);
        pieModel1.setShadow(false);
        pieModel1.setFill(false);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(150);
          System.out.println(" Create PI Model One with data setup here ====");
    }
      
    
    
     private BarChartModel initBarModel2() throws ClassNotFoundException, SQLException {
       BarChartModel modelfemalemale=new BarChartModel();
 
        String yefayluaynet[]={ "አቤቱታ","ቀጥተኛ ክስ","ይግባኝ","ሰበር","አፈፃፀም"};
      malefemale= new int[datesgenerated.length][yefayluaynet.length];
  	
			  
                        for(Mebtnatkmmyefetabherafetatem dr :allMebtnatkmmyefetabherafetatem )    
                        {
                            System.out.println("here is ======>"+dr.getMezgebuyetewesenebetken());
                            String date[]=dr.getMezgebuyetewesenebetken().split("/");

   if(year.equalsIgnoreCase(date[2])&& dr.getYefayluaynet()!=null){  
             for(int i=0;i<datesgenerated.length;i++){ 
                 
                   //  System.out.println("The year is"+datesgenerated[i]+" and  school is ====>"+dr.getDateofarrival() +" ICU admission is "+dr.getSymptomspresent());
                       for(int t=0;t<yefayluaynet.length;t++) 
               
                       { 
                           // this will generate type of file which are decide but we can igonore to get all 
                          if((datesgenerated[i].equalsIgnoreCase(dr.getMezgebuyetewesenebetken())) && (dr.getYefayluaynet().equalsIgnoreCase(yefayluaynet[t]) )){
                                                                    
                                        malefemale[i][t]=malefemale[i][t]+1;
                                      }
                         
                         
                       
                            }
                          }/// while
                         // end of whoile
   }// end if
                        }// end for 
                        
                         
        /// try block    
         // try blok
                 
   ChartSeries  chartmalefemale[];
        chartmalefemale= new ChartSeries[yefayluaynet.length];
        for(int i=0;i<yefayluaynet.length;i++)
        {
            chartmalefemale[i]=new ChartSeries();
        chartmalefemale[i].setLabel(yefayluaynet[i]);
        }
       
        
      
       for(int i=0;i<datesgenerated.length;i++){
           //System.out.println("this is college ==> for setup"+datesgenerated[i]);
           
      for(int m=0;m<yefayluaynet.length;m++)
      {
             
                 chartmalefemale[m].set(datesgenerated[i], malefemale[i][m]);
//                    System.out.println("<=============>"+malefemale[i][m]);
  //  System.out.println(datesgenerated[i]);
      }
       }
       for(int y=0;y<yefayluaynet.length;y++){
           
      modelfemalemale.addSeries(chartmalefemale[y]);
       
       }
          System.out.println("model return finished here  for model two for cases  ");
       return   modelfemalemale;
    }
// patient level with outcome 
     
     int totalforlevels[]={0};
          private BarChartModel initBarModel3()  throws ClassNotFoundException, SQLException {
       BarChartModel modelfemalemale=new BarChartModel();
        String yefayluaynet[]={"አቤቱታ","ቀጥተኛ ክስ","ይግባኝ","ሰበር","አፈፃፀም"};
         	// Gudayu Yalekebet Huneta Zrzr guday
        totalforlevels= new int[yefayluaynet.length];
      malefemale= new int[datesgenerated.length][yefayluaynet.length];
 
			  
                        for(Mebtnatkmmyefetabherafetatem dr :allMebtnatkmmyefetabherafetatem )    
                        {
                            System.out.println("here is ======>"+dr.getMezgebuyetekefetebetken());
                            String date[]=dr.getMezgebuyetewesenebetken().split("/");
      System.out.println(" The year is===>"+date[2]);
   if(year.equalsIgnoreCase(date[2])){  
             for(int i=0;i<datesgenerated.length;i++){ 
                 
                   //  System.out.println("The year is"+datesgenerated[i]+" and  school is ====>"+dr.getDateofarrival() +" ICU admission is "+dr.getSymptomspresent());
                             try{
                                 for(int l=0;l<yefayluaynet.length;l++)
                                 {
                          if((datesgenerated[i].equalsIgnoreCase(dr.getMezgebuyetekefetebetken())) && (dr.getYefayluaynet().equalsIgnoreCase(yefayluaynet[l]) )){
                                                                    
                                        malefemale[i][l]=malefemale[i][l]+1;
                                      }
                          
                                 }
                               
                          }
                             
                             catch(Exception e)
                             {
                                 e.printStackTrace();
                             }
             
                    
             }
                          }/// while
                        
                        }
                      
                 
   ChartSeries  chartmalefemale[];
        chartmalefemale= new ChartSeries[yefayluaynet.length];
        for(int i=0;i<yefayluaynet.length;i++)
            chartmalefemale[i]=new ChartSeries();
          for(int l=0;l<yefayluaynet.length;l++)
          {
        chartmalefemale[l].setLabel(yefayluaynet[l]);
          }
      
        
      
       for(int i=0;i<datesgenerated.length;i++){
           //System.out.println("this is college ==> for setup"+datesgenerated[i]);
           
      for(int m=0;m<yefayluaynet.length;m++)
      {
             
                 chartmalefemale[m].set(datesgenerated[i], malefemale[i][m]);
//                    System.out.println("<=============>"+malefemale[i][m]);
  //  System.out.println(datesgenerated[i]);
      }
       }
       for(int y=0;y<yefayluaynet.length;y++){
           
      modelfemalemale.addSeries(chartmalefemale[y]);
       
       }
        
       return   modelfemalemale;
    }
     
     
    public String getYear() {
        return year;
        
    }

    public void setYear(String year) {
        this.year = year;
    }

  
 
    private void createPieModels() {
        createPieModel1();
     createPieModelforfinaloutcome();
    }
   
    private void createPieModelforfinaloutcome() {
        pieModelforfinaloutcome = new PieChartModel();
         for(int k=0;k<totalforlevels.length;k++)
         {
         pieModelforfinaloutcome .set(totalforlevels[k]+10 +"="+totalforlevels[k]+10 , totalforlevels[k]);
        }
        pieModelforfinaloutcome .setTitle("Covid19 Total outcome Based Reports  "+year);
        pieModelforfinaloutcome .setLegendPosition("w");
        pieModelforfinaloutcome .setMouseoverHighlight(true);
        pieModelforfinaloutcome .setShadow(true);
        pieModelforfinaloutcome .setFill(false);
        pieModelforfinaloutcome .setShowDataLabels(true);
        pieModelforfinaloutcome .setDiameter(150);
    }

    public PieChartModel getPieModelforfinaloutcome() {
        return pieModelforfinaloutcome;
    }

    public void setPieModelforfinaloutcome(PieChartModel pieModelforfinaloutcome) {
        this.pieModelforfinaloutcome = pieModelforfinaloutcome;
    }
      
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                        "Value: " + event.getItemIndex() + ", Dates " + event.getSeriesIndex());
       FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public  void process_modeOf_delivery_by_year(String yr) {
          setYear(yr);
          setNumberofdaytocomeback(yr);
          //generateDays(numberofdaytocomeback);
           System.out.println(" inside process of mode and incoming is"+yr);
         try {           
            createBarModels();
         
            createPieModels();
            
  // design();
            
        } catch (Exception ex) {
           Logger.getLogger(ReportParticipationMebtnatkm.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }

 public StreamedContent getGraphicText() {
        return graphicText;
    }
         
    public StreamedContent getChart() {
        return chart;
    }
       private StreamedContent graphicText;
         
    private StreamedContent chart;
    
    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
         for(int k=0;k<datesgenerated.length;k++)
         {
              String institute=null;
             String []strArray=datesgenerated[k].split(" ");
for(int i=0; i<strArray.length;i++) {
    if(strArray[i].equalsIgnoreCase("College") || strArray[i].equalsIgnoreCase("of") ||strArray[i].equalsIgnoreCase("Faculty") || strArray[i].equalsIgnoreCase("Scholl")||strArray[i].equalsIgnoreCase("Faculty") || strArray[i].equalsIgnoreCase("Institute"))
         institute="";
    else
        institute+=" "+strArray[i];
     
}
         dataset.setValue(datesgenerated[k] +"="+daystotal[k] , daystotal[k]);
         
         }
     
        return dataset;
    }
    
    ArrayList<MonthsandDataFeedcovid> datesgeneratedwithdata = new ArrayList<MonthsandDataFeedcovid>();

    public ArrayList<MonthsandDataFeedcovid> getDatesgeneratedwithdata() {
      
         datesgeneratedwithdata = new ArrayList<>();
         
      int  valuesbasedondifferentcase [][] = new int [datesgenerated.length][5];
         
        for(Mebtnatkmmyefetabherafetatem t : allMebtnatkmmyefetabherafetatem)
        {
         /*
            for(int i=0;i<datesgenerated.length;i++)
            {
                if(t.getLaboratorytestresult()!=null)
                {
           if(t.getLaboratorytestresult().equalsIgnoreCase("+ve"))
               valuesbasedondifferentcase [i][0]+=1;
           if(t.getLaboratorytestresult().equalsIgnoreCase("-ve"))
               valuesbasedondifferentcase [i][1]+=1; 
                }
                 if(t.getFinaloutcome()!=null){
              if(t.getFinaloutcome().equalsIgnoreCase("death"))
               valuesbasedondifferentcase [i][2]+=1; 
              if(t.getFinaloutcome().equalsIgnoreCase("improved"))
               valuesbasedondifferentcase [i][4]+=1; 
                 }
                 if(t.getIcuadmitted()!=null){
             if(t.getIcuadmitted().equalsIgnoreCase("yes"))
               valuesbasedondifferentcase [i][3]+=1;  
                 }
        }
*/
        }
         for(int j=0;j<datesgenerated.length;j++)
         {
      System.out.println("+ve"+valuesbasedondifferentcase[j][0]+"===>"+datesgenerated[j]);
      System.out.println("-ve"+valuesbasedondifferentcase[j][1]+"===>"+datesgenerated[j]);
      System.out.println("death"+valuesbasedondifferentcase[j][2]+"===>"+datesgenerated[j]);
       MonthsandDataFeedcovid data = new MonthsandDataFeedcovid();
      data.setRowheading(datesgenerated[j] );
      data.setPositive(valuesbasedondifferentcase[j][0]);
      data.setNegative(valuesbasedondifferentcase[j][1]);
      data.setDeath(valuesbasedondifferentcase[j][2]);
      data.setIcuadmitted(valuesbasedondifferentcase[j][3]);
      data.setImproved(valuesbasedondifferentcase[j][4]);
       
         
        // data.(""+eachstatus[j]);
   System.out.println(")))))))))))))))))))))))))))))))))))))");
           datesgeneratedwithdata.add(data);
    } // end

        return datesgeneratedwithdata;
    }

    public void setDatesgeneratedwithdata(ArrayList<MonthsandDataFeedcovid> datesgeneratedwithdata) {
         
        this.datesgeneratedwithdata = getDatesgeneratedwithdata();
    }
    
   

    public void setdatesgeneratedwithdata(ArrayList<MonthsandDataFeedcovid> datesgeneratedwithdata) {
        
       this.datesgeneratedwithdata = datesgeneratedwithdata;
    }
      
    
     
      
}








