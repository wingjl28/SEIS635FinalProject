package com.skunk;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDie {

	@Test
	void test_predictable() {
		Die predicatableDie = new Die(5);
		
		predicatableDie.roll(); //no change to value of die
		
		assertEquals(predicatableDie.getLastRoll(), 5);
	}
	
	@Test
	void test_random() {
		//in order to attempt to test a random "fair" die, we are going to roll 
		//the die a lot of times, and keep track of each value. Then we are going 
		//to make sure that we are getting a relatively "fair" distribution.
		//This could be done better with stats, but we are going to assume that of 600 rolls,
		//we won't get 100 of each, but should get at least 50 of each.
		
		Die randomDie = new Die();;
		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		int fourCount = 0; 
		int fiveCount = 0;
		int sixCount = 0;
		int elseCount = 0;
		
		
		for (int i = 0; i < 600; i++) {
			randomDie.roll();
			
			switch (randomDie.getLastRoll()) {
				case 1:
					oneCount++;
					break;
				case 2:
					twoCount++;
					break;
				case 3: 
					threeCount++;
					break;
				case 4:
					fourCount++;
					break;
				case 5:
					fiveCount++;
					break;
				case 6:
					sixCount++;
					break;
				default:
					elseCount++;
					break;
			}
					
		}
		
		
		assertTrue(oneCount > 50);
		assertTrue(twoCount > 50);
		assertTrue(threeCount > 50);
		assertTrue(fourCount > 50);
		assertTrue(fiveCount > 50);
		assertTrue(sixCount > 50);
		assertEquals(elseCount, 0);
	}
	

}
