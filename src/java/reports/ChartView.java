package reports;
import com.database.Mebtnatkmmyefetabherafetatem;
import com.database.MebtnatkmmyefetabherafetatemFacade;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
@Named
@SessionScoped
public class ChartView implements Serializable {
 
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private LineChartModel zoomModel;
   
    private LineChartModel areaModel;
    private BarChartModel barModel;
   
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
  
    private PieChartModel livePieModel;
    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
    private LineChartModel multiAxisModel;
    private LineChartModel dateModel;
 
     @EJB
    private com.database.MebtnatkmmyefetabherafetatemFacade  MebtnatkmmyefetabherafetatemejbFacade;

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(LineChartModel areaModel) {
        this.areaModel = areaModel;
    }

    public MebtnatkmmyefetabherafetatemFacade getMebtnatkmmyefetabherafetatemejbFacade() {
        return MebtnatkmmyefetabherafetatemejbFacade;
    }

    public void setMebtnatkmmyefetabherafetatemejbFacade(MebtnatkmmyefetabherafetatemFacade MebtnatkmmyefetabherafetatemejbFacade) {
        this.MebtnatkmmyefetabherafetatemejbFacade = MebtnatkmmyefetabherafetatemejbFacade;
    }
    
    HashMap<String, String>  weeklyadmitted = new HashMap<>();
     private List<Mebtnatkmmyefetabherafetatem> allmebtnatkmfiles;
     private String[] days;
     private int[] daystotal;
     String reportingdates[];
    @PostConstruct
    public void init() {
        
        System.out.println("Total Mebtnatkmmyefetabherafetatem size is==>"+MebtnatkmmyefetabherafetatemejbFacade.count());
      reportingdates= new String[10];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
          

int j=0;
for(int i=-9;i<=0;i++)
{
   Calendar calendar =Calendar.getInstance(); 
calendar.add(Calendar.DATE, i);

int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH)+1;
int day = calendar.get(Calendar.DAY_OF_MONTH);
  String ethiopiandate= ConvertToEthiopian(year, month, day);
System.out.println(i+" this is calnader===> "+day+"--"+month+"--"+year+"===>"+ethiopiandate);
 reportingdates[j]=ethiopiandate;

 
 j++;
}


 //Prints 26/10/2015
        days =new String[10];
        daystotal= new int[10];
        int i=0;
        allmebtnatkmfiles=MebtnatkmmyefetabherafetatemejbFacade.findAll();
        



        
       for(Mebtnatkmmyefetabherafetatem s:allmebtnatkmfiles)
        {
            
           for(int k=0;k<10;k++)
            {
        if(s.getMezgebuyetewesenebetken().equalsIgnoreCase(reportingdates[k]))
        {
 //System.out.println("comparsion"+s.getFirtstname()+"==>"+ s.getDateofarrival()+"====>"+ethiopiandate);
      daystotal[k]+=1;
            
        }
        i++;
        }
        }
        
        createLineModels();
        createAreaModel();
        createPieModels();
     
        createBarModels();
        createAnimatedModels();
     
        createDateModel();
        print();
        
    }
    public void print()
    {
        
      for(int i=0;i<reportingdates.length;i++)
      {
     System.out.println("date "+reportingdates[i]+" total ===>"+daystotal[i]); 
      }
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
    
    System.out.println("This after conversion month value in Ethiopia"+dtEthiopic.getMonthOfYear());
    int year=dtEthiopic.getYear();
    String builder;
    String d=day<10? "0"+day:day+"";
    String m=mon<10? "0"+mon:mon+"";
          
    
    return d+"/"+ m+"/"+year+"";
}
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
 
    public LineChartModel getZoomModel() {
        return zoomModel;
    }
 
   
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
   
    public BarChartModel getBarModel() {
        return barModel;
    }
 

 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }
 
    public LineChartModel getDateModel() {
        return dateModel;
    }
 
    public PieChartModel getLivePieModel() {
        int random1 = (int) (Math.random() * 1000);
        int random2 = (int) (Math.random() * 1000);
 
        livePieModel.getData().put("Candidate 1", random1);
        livePieModel.getData().put("Candidate 2", random2);
 
        livePieModel.setTitle("Votes");
        livePieModel.setLegendPosition("ne");
 
        return livePieModel;
    }
 
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        
             for(int i=0;i<reportingdates.length;i++)
      {
         
     
     boys.set(reportingdates[i], daystotal[i]);
     
     
      }
             /*
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
    */
        model.addSeries(boys);
       // model.addSeries(girls);
 
        return model;
    }
 
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
 
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(20); // this for catagory chart
 
        zoomModel = initLinearModel();
        zoomModel.setTitle("Zoom");
        zoomModel.setZoom(true);
        zoomModel.setLegendPosition("e");
        yAxis = zoomModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
 
    private void createAreaModel() {
        areaModel = new LineChartModel();
 
        LineChartSeries boys = new LineChartSeries();
        boys.setFill(true);
        boys.setLabel("Boys");
        
          for(int i=0;i<reportingdates.length;i++)
      {
         
     
     boys.set(reportingdates[i], daystotal[i]);
     
     
      }
       /* boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
  */
        LineChartSeries girls = new LineChartSeries();
        girls.setFill(true);
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        areaModel.addSeries(boys);
       // areaModel.addSeries(girls);
 
        areaModel.setTitle("Area Chart");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
 
        Axis xAxis = new CategoryAxis("Years");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        
        for(int i=0;i<reportingdates.length;i++)
      {
         
     
     boys.set(reportingdates[i], daystotal[i]);
     
     
      }
        /* boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
   */
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        
          for(int i=0;i<reportingdates.length;i++)
      {
         
     
     girls.set(reportingdates[i], daystotal[i]);
     
     
      }
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        model.addSeries(boys);
       // model.addSeries(girls);
 
        return model;
    }
 
    private void createBarModels() {
        createBarModel();
        
    }
 
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
 
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
 
        return model;
    }
 
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
        createLivePieModel();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
 
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
 
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
 
        pieModel2.set("Brand 1", 540);
        pieModel2.set("Brand 2", 325);
        pieModel2.set("Brand 3", 702);
        pieModel2.set("Brand 4", 421);
 
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        pieModel2.setShadow(false);
    }
 
    
    
 
    private void createLivePieModel() {
        livePieModel = new PieChartModel();
 
        livePieModel.set("Candidate 1", 540);
        livePieModel.set("Candidate 2", 325);
    }
 
   
 
   
    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Line Chart");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
 
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Bar Charts");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
 
    private void createDateModel() {
        dateModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Qaurentine Center");
 for(int i=0;i<reportingdates.length;i++)
      {
          String []dates=reportingdates[i].split("/");
          String newformat=dates[2]+"-"+dates[1]+"-"+dates[0];
     System.out.println("New Format "+reportingdates[i]+" is  ===>"+newformat); 
     
     series1.set(newformat, daystotal[i]);
     
     
      }
        
        
      /*  series1.set("2014-01-01", 51);
        series1.set("2014-01-06", 22);
        series1.set("2014-01-12", 65);
        series1.set("2014-01-18", 74);
        series1.set("2014-01-24", 24);
        series1.set("2014-01-30", 51);
       */
      
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        for(int i=0;i<reportingdates.length;i++)
      {
    String []dates=reportingdates[i].split("/"); 
       String newformat=dates[2]+"-"+dates[1]+"-"+dates[0];
     series2.set(newformat, daystotal[i]);
     
     
      }
        
       /* series2.set("2014-01-01", 32);
        series2.set("2014-01-06", 73);
        series2.set("2014-01-12", 24);
        series2.set("2014-01-18", 12);
        series2.set("2014-01-24", 74);
        series2.set("2014-01-30", 62);
   */
        dateModel.addSeries(series1);
        dateModel.addSeries(series2);
 
        dateModel.setTitle("Zoom for Details");
        dateModel.setZoom(true);
        dateModel.getAxis(AxisType.Y).setLabel("Values");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
       
 
        dateModel.getAxes().put(AxisType.X, axis);
    }
}