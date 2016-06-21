package p1;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.date.DateUtilities;

public class CreateChart {
	public void createXYChart(String Cname,String StartDate,String EndDate){
		System.out.println("in createchart");
		Dbconnection con=new Dbconnection();
		float s1;
		Date s2;
		try {
		Connection conn=con.getConnection();
		
		PreparedStatement stmt=conn.prepareStatement("select close_price,i_date from "+Cname+" where i_date>=? and i_date<=?");
		stmt.setString(1, StartDate);
		stmt.setString(2, EndDate);
		ResultSet rs=stmt.executeQuery();
		System.out.println("1");
		TimeSeries pop = new TimeSeries("time");
		System.out.println("2");
		while(rs.next()){
		s1=rs.getFloat(1);
		s2=rs.getDate(2);
		Day d=new Day(s2);
		pop.add(d, s1);       
		        //         Add the series to your data set   
		}
		TimeSeriesCollection dataset=new TimeSeriesCollection();         
		dataset.addSeries(pop);          //         Generate the graph         
		JFreeChart chart = ChartFactory.createTimeSeriesChart("Technical Analysis", "Time","Price",dataset,true,true,false); 
		System.out.println("3");
		try {             
			ChartUtilities.saveChartAsJPEG(new File("D://chart.jpg"), chart, 1000,600); 
			System.out.println("4");
		} catch (IOException e) {             
			System.err.println("Problem occurred creating chart.");         
		}   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void createBarChart(String Cname,String StartDate,String EndDate){
		Dbconnection con=new Dbconnection();
		int s1;
		Date s2;
		String s3,s4;
		Connection conn;
		try {
			conn = con.getConnection();
		PreparedStatement stmt=conn.prepareStatement("select volume,i_date from "+Cname+" where i_date>=? and i_date<=?");
		stmt.setString(1, StartDate);
		stmt.setString(2, EndDate);
		ResultSet rs=stmt.executeQuery();
		TimeSeries pop = new TimeSeries("vijay");
        while(rs.next()){
    		s1=rs.getInt(1);
    		s2=rs.getDate(2);
    		s3=s2.toString();
    		s4=s3.substring(8);
    		System.out.println(s4);
    		Day d=new Day(s2);
    		pop.add(d, s1);
        }
        TimeSeriesCollection dataset=new TimeSeriesCollection();         
		dataset.addSeries(pop);
		JFreeChart chart = ChartFactory.createXYBarChart("Volume Chart", "Time", true,"Volume", dataset, PlotOrientation.VERTICAL,false, true, false);
        try {
            ChartUtilities.saveChartAsJPEG(new File("D://chart1.jpg"), chart, 1000,
                300);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void createSMAChart(String Cname){
		Dbconnection con=new Dbconnection();
		SMAcalc s=new SMAcalc();
		double s1[];
		double s3[];
		int l=0;
		Date s2[];
		try {
		Connection conn=con.getConnection();
		
		PreparedStatement stmt=conn.prepareStatement("select close_price,i_date from "+Cname);
		ResultSet rs=stmt.executeQuery();
		System.out.println("1");
		TimeSeries pop = new TimeSeries("time1");
		System.out.println("2");
		System.out.println(rs.getFetchSize());
		s1=new double[1000];
		s2=new Date[1000];
		for(int i=0;rs.next();i++){
		s1[i]=rs.getFloat(1);
		s2[i]=rs.getDate(2);
		l++;     
		        //         Add the series to your data set   
		}
		System.out.println(l);
		s3= new double[l-29];
		s3=s.SMA_calc(s1);
		for(int j=0;j<(l-29);j++){
		Day d=new Day(s2[j]);
		pop.add(d, s3[j]);
		}
		TimeSeriesCollection dataset=new TimeSeriesCollection();         
		dataset.addSeries(pop);          //         Generate the graph         
		JFreeChart chart = ChartFactory.createTimeSeriesChart("SMA chart", "Time","Price",dataset,true,true,false); 
		System.out.println("3");
		try {             
			ChartUtilities.saveChartAsJPEG(new File("D://chart5.jpg"), chart, 1000,600); 
			System.out.println("4");
		} catch (IOException e) {             
			System.err.println("Problem occurred creating chart.");         
		}   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void createCandlestickChart(String Cname,String StartDate,String EndDate) throws SQLException{
		Dbconnection con=new Dbconnection();
		 OHLCDataset data;
		    Date date1=new Date();
			Date[] date = new Date[261];
			  double[] high = new double[261];
			  double[] low = new double[261];
			  double[] open = new double[261];
			  double[] close = new double[261];
			  double[] volume = new double[261];
			  String s1,s2,s3,s4;
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement("select * from "+Cname+" where i_date>=? and i_date<=?");
			stmt.setString(1, StartDate);
			stmt.setString(2, EndDate);
			ResultSet rs=stmt.executeQuery();
			System.out.println(rs.getFetchSize());
			
			for (int ii = 0; rs.next(); ii++) {
				  date1=rs.getDate(2);
				  System.out.println(date1);
				  s1=date1.toString();
				  s2=s1.substring(0, 4);
				  s3=s1.substring(6, 7);
				  s4=s1.substring(8);
				  date[ii]  = DateUtilities.createDate(Integer.parseInt(s2), Integer.parseInt(s3), Integer.parseInt(s4), 12, 0);
				  high[ii] = rs.getDouble(4);
				  low[ii] = rs.getDouble(5);
				  open[ii] = rs.getDouble(3);
				  close[ii] = rs.getDouble(6);
				  volume[ii] = rs.getLong(7);
				  }
			System.out.println(date[259]);
		    System.out.println(high[259]);
		    System.out.println(low[259]);
		    System.out.println(open[259]);
		    System.out.println(close[259]);
		    System.out.println(volume[259]);
			System.out.println(date.length);
			 Date[] arrayOfDate = new Date[rs.getFetchSize()];
			    double[] arrayOfDouble1 = new double[rs.getFetchSize()];
			    double[] arrayOfDouble2 = new double[rs.getFetchSize()];
			    double[] arrayOfDouble3 = new double[rs.getFetchSize()];
			    double[] arrayOfDouble4 = new double[rs.getFetchSize()];
			    double[] arrayOfDouble5 = new double[rs.getFetchSize()];
			for (int k=0;k<rs.getFetchSize();k++){
		    arrayOfDate[k] = date[k];
		    arrayOfDouble1[k] = (double)high[k];
		    arrayOfDouble2[k] =(double) low[k];
		    arrayOfDouble3[k] = (double)open[k];
		    arrayOfDouble4[k] = (double)close[k];
		    arrayOfDouble5[k] = (double)volume[k];
			}
		data = new DefaultHighLowDataset("Series 1", arrayOfDate, arrayOfDouble1, arrayOfDouble2, arrayOfDouble3, arrayOfDouble4, arrayOfDouble5);
       //ChartFactory.createBarChart("Comparison between Salesman",
              // "Salesman", "Profit", (CategoryDataset)dataset, PlotOrientation.VERTICAL, false,
              // true, false);
       JFreeChart chart = ChartFactory.createCandlestickChart("candle stick chart", "time", "price", data, false);
       try {
           ChartUtilities.saveChartAsJPEG(new File("D://chart6.jpg"), chart, 500,
               300);
       } catch (IOException e) {
           System.err.println("Problem occurred creating chart.");
       }
	}
}
