package lab9;
import org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab9Test{

	private static Lab9 l9;
	
	@BeforeClass
	public void setUpNewLab8() {
		System.out.println("This method will run before any of the method");
		l9 = new Lab9();
	}
	
	@Before
	public void setUpBeforeEachTest() {
		System.out.println("This will run before each test");
	}
	
	@After
	public void tearDownAfterEachTest() {
		System.out.println("This will run after each test");
	}
	
	@AfterClass
	public void tearDownAfterEachClass() {
		System.out.println("This will run after the entire class");
	}
	
	@Test
	public void calculateBonuses1() {
		char[] ch = {'F','D','D', 'B'};
		int[] expected = {0, 500, 500, 2500};
		ArrayList<Integer> actual = l9.calculateBonuses(ch);
		for(Integer i : actual ) {
		assertEquals("calculate bonus", expected[i], actual.get(i)); 
		}
	}

	private void assertEquals(String string, int i, Integer integer) {
		// TODO Auto-generated method stub
		
	}
}
