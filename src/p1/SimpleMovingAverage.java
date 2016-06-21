package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleMovingAverage {
	float close[];
	double sum,sma,result;
	String name;
	public double calculateSMA(int days,String cname) throws SQLException{
		close=new float[days];
		Dbconnection con=new Dbconnection();
		Connection conn=con.getConnection();
		if(cname.equals("IBM")){
			name="ibm_details";
		}
		else if(cname.equals("Amazon")){
			name="Amazon_details";
		}
		else if(cname.equals("dell"))
		{
			name="dell_details";
		}
		else if(cname.equals("hp"))
		{
			name="hp_details" ;
		}
		else if(cname.equals("Oracle"))
		{
			name="oracle_details";
		}
		PreparedStatement stmt=conn.prepareStatement("select close_price from (select close_price from "+name+" order by id desc) where ROWNUM<=?");
		stmt.setInt(1, days);
		ResultSet rs=stmt.executeQuery();
		for(int i=0;rs.next();i++){
			
			close[i]=rs.getFloat(1);
		}
		result=smaCalculate(close, days);
		return result;
	}
	public double smaCalculate(float[] close,int days){
		for(int j=0;j<days;j++){
			sum+=close[j];
		}
		return (sum/days);
	}
}
