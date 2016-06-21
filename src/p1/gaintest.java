package p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class gaintest {
  gain s;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s=new gain();
	}

	@After
	public void tearDown() throws Exception {
	}

	

	
	@Test
	public void testCalculationofgain() 
	{
	assertTrue(((Math.round(s.calculationofgain(3.0f,5.0f)*100.0f))/100.0f)==66.67f)	;
	assertTrue(((Math.round(s.calculationofgain(5.0f,3.0f)*100.0f))/100.0f)==-40.0f)	;
	assertTrue(((Math.round(s.calculationofgain(2.34f,5.65f)*100.0f))/100.0f)==141.45f)	;
	assertTrue(((Math.round(s.calculationofgain(5.65f,2.34f)*100.0f))/100.0f)==-58.58f)	;
	assertTrue(((Math.round(s.calculationofgain(6.95f,9.46f)*100.0f))/100.0f)==36.12f)	;
	assertTrue(((Math.round(s.calculationofgain(9.46f,6.95f)*100.0f))/100.0f)==-26.53f)	;
	assertTrue(((Math.round(s.calculationofgain(9.54f,9.54f)*100.0f))/100.0f)==00.0f)	;
	assertTrue(((Math.round(s.calculationofgain(9.0f,6.0f)*100.0f))/100.0f)==-33.33f)	;
	assertTrue(((Math.round(s.calculationofgain(76.28f,56.4f)*100.0f))/100.0f)==-26.06f);
	
	
	}

}
