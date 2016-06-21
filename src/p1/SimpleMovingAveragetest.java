package p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleMovingAveragetest {
    SimpleMovingAverage sma;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sma=new SimpleMovingAverage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSmaCalculate() {
		float b[]={5,4};
		assertTrue(((Math.round(sma.smaCalculate(b, 2)*100.0f))/100.0f)==4.50f);
		float c[]={3,5,6,9};
		assertFalse(((Math.round(sma.smaCalculate(c, 4)*100.0f))/100.0f)==5.73f);
		float c1[]={3,5,6,9,11};
		assertFalse(((Math.round(sma.smaCalculate(c1, 5)*100.0f))/100.0f)==6.75f);
	}

}
