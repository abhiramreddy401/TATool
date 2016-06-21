package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class gain{
	float open,close,result;
		public float gaincalculation(String cname){
			Dbconnection con=new Dbconnection();
			
			try{
				Connection conn=con.getConnection();
				System.out.println("1");
				PreparedStatement stmt=conn.prepareStatement("select open_price,close_price from "+cname+" order by id desc");
				System.out.println("2");
				ResultSet rs=stmt.executeQuery();
				System.out.println("3");
				while(rs.next()){
				open=rs.getFloat(1);
				close=rs.getFloat(2);
				break;
				}
				System.out.println(open);
				System.out.println(close);
				result=calculationofgain(open, close);
				System.out.println(result);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return result;
		}
				
			  public float calculationofgain( float open, float close )
			  { 
				return (((close-open)*100)/open);
  
			  }

}
