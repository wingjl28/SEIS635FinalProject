import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

import org.junit.Test;

public class TestDie
{

	@Test
	public void testDieRoll()
	{
		Die testDie = new Die();
		ArrayList<Integer> rollValues = new ArrayList<Integer>();
		//roll dice 1000 times to try to get each roll possibility
		for (int i = 0; i < 1000; i++) {
			testDie.roll();
			assertTrue(testDie.getLastRoll() > 0 && testDie.getLastRoll() < 7);
			rollValues.add(testDie.getLastRoll());
		}
		//test to see if each value could be rolled 
		assertTrue(rollValues.contains(1));
		assertTrue(rollValues.contains(2));
		assertTrue(rollValues.contains(3));
		assertTrue(rollValues.contains(4));
		assertTrue(rollValues.contains(5));
		assertTrue(rollValues.contains(6));
	}
	
	@Test
	public void testDieGetLastRoll()
	{
		Die testDie = new Die(6);
		assertTrue(testDie.getLastRoll() == 6);	
	}
	
	@Test
	public void testDieToString()
	{
		Die testDie = new Die(6);
		String toString = "Die: 6";
		assertTrue(testDie.toString().equals(toString)); 
	}

}
