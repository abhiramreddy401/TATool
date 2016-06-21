package p1;

import java.sql.SQLException;

public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		SimpleMovingAverage sm=new SimpleMovingAverage();
		System.out.println(sm.calculateSMA(3,"dell"));
	}

}
