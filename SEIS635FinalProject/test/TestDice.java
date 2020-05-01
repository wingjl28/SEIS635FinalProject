import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/* This test is to test the "unpredictable" dice 
 * 
 * This can be tested by taking a large number of rolls, and ensuring that using two dice, each of the values between 2 and 12 are rolled (at least once)
 * and that no values less than 2 or greater than 12 are rolled.
 * 
 * In theory this test COULD fail, but the odds are basically 0. If if were to fail, this would assume some sort of unfair dice.
 * 
 * 
 * */

class TestDice {

	@Test
	void test_unpredict() {
		
		Dice dice1 = new Dice();
		
		boolean rollTwo = false;
		boolean rollThree = false;
		boolean rollFour = false;
		boolean rollFive = false;
		boolean rollSix = false;
		boolean rollSeven = false;
		boolean rollEight = false;
		boolean rollNine = false;
		boolean rollTen = false;
		boolean rollEleven = false;
		boolean rollTwelve = false;
		boolean rollOverTwelve = false;
		boolean rollUnderTwo = false;
		
		
		//roll dice 10000 times and check to see if all values between 2 and 12 are rolled at least once
		// and that no other values are rolled.
		for (int i = 0; i < 10000; i++) {
			
			dice1.roll();
			
			switch(dice1.getLastRoll()) {
			
			case 2:
				rollTwo = true;
				break;
			
			case 3:
				rollThree = true;
				break;
			case 4:
				rollFour = true;
				break;
			case 5:
				rollFive = true;
				break;
			case 6:
				rollSix = true;
				break;
			case 7:
				rollSeven = true;
				break;
			case 8:
				rollEight = true;
				break;
			case 9:
				rollNine = true;
				break;
			case 10:
				rollTen = true;
				break;
			case 11:
				rollEleven = true;
				break;
			case 12:
				rollTwelve = true;
				break;
			default:
				if (dice1.getLastRoll() < 2)
					rollUnderTwo = true;
				else
					rollOverTwelve = true;
			}
			
		}
		//All values between 2 and 12 should be true (rolled at least once)
		assertTrue(rollTwo);
		assertTrue(rollThree);
		assertTrue(rollFour);
		assertTrue(rollFive);
		assertTrue(rollSix);
		assertTrue(rollSeven);
		assertTrue(rollEight);
		assertTrue(rollNine);
		assertTrue(rollTen);
		assertTrue(rollEleven);
		assertTrue(rollTwelve);
		
		//All values less than 2 and greater than 12 should be false (never rolled)
		assertFalse(rollUnderTwo);
		assertFalse(rollOverTwelve);
		
	}
	
	@Test
	void test_predict() {
		Die predDieOne = new Die(1);
		Die predDieTwo = new Die(6);
		
		Dice predDice = new Dice(predDieOne, predDieTwo);
		predDice.roll();
		assertEquals(predDice.getLastRoll(), 7);
		
		assertEquals(predDice.getDie1().getLastRoll(), 1);
		assertEquals(predDice.getDie2().getLastRoll(),6);
		
		Die oneDie = new Die(1);
		Die twoDie = new Die(2);
		Die threeDie = new Die(3);
		
		Dice doubleSkunk = new Dice(oneDie, oneDie);
		doubleSkunk.roll();
		assertEquals(doubleSkunk.getSkunkType(), SkunkType.DOUBLE);
		//NONE, SINGLE, SKUNKDUECE, DOUBLE
		
		Dice singleSkunk = new Dice(oneDie, threeDie);
		singleSkunk.roll();
		assertEquals(singleSkunk.getSkunkType(), SkunkType.SINGLE);
		
		Dice skunkDeuce = new Dice(oneDie, twoDie);
		skunkDeuce.roll();
		assertEquals(skunkDeuce.getSkunkType(), SkunkType.SKUNKDUECE);
		
		Dice noSkunk= new Dice(threeDie, threeDie);
		noSkunk.roll();
		assertEquals(noSkunk.getSkunkType(), SkunkType.NONE);
		
		assertEquals(noSkunk.toString(), "Dice with last roll: 6 => 3 + 3");
	}

}
