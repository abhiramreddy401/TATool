package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	Connection con;
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tatool","root","root");
			return con;
		}catch(ClassNotFoundException e){
			System.out.println("database not connected");
			return null;
		}
	}

}
