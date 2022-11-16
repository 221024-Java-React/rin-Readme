package lab8;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab8Tests {

	private static Lab8 l8;
	
	@BeforeClass
	public void setUpNewLab8() {
		System.out.println("This method will run before any of the method");
		l8 = new Lab8();
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
	public void reverseString1() {
		String actual = l8.reverse("rinchheng");
		assertEquals("rinchheng", "gnehhcnir",actual); 
	}
}
