package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayData {
	public float open,high,low,close;
	public int volume;
	public void DisplayDefaultData(String cname){
		Dbconnection con=new Dbconnection();
		
		try {
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement("select * from "+cname+" order by id desc");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				open=rs.getFloat(3);
				high=rs.getFloat(4);
				low=rs.getFloat(5);
				close=rs.getFloat(6);
				volume=rs.getInt(7);
				break;
				}
		System.out.println(open);	
		System.out.println(close);
		System.out.println(low);
		System.out.println(high);
		System.out.println(volume);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
