package testskunk;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.skunk.Dice;

class TestDice {

	@Test
	void test_predictable_dice() {
		
		Dice predDice = new Dice(1,6);
		
		assertEquals(predDice.getDie1().getLastRoll(), 1);
		assertEquals(predDice.getDie2().getLastRoll(), 6);
		assertEquals(predDice.getLastRoll(), 7);
		
		//rolling method should not change any values 
		predDice.roll();
		assertEquals(predDice.getDie1().getLastRoll(), 1);
		assertEquals(predDice.getDie2().getLastRoll(), 6);
		assertEquals(predDice.getLastRoll(), 7);
		
	}
	
	@Test
	void test_random_dice() {
		
		//We already tested fair die individually in DieTest,
		//so, for here, all we can do is test that values between 2 and 12 are the
		//only values created by rolling a lot, we can also test that when i get die1 
		//and die 2 values individually, they add to be the lastRoll() value.
		
		Dice randDice = new Dice();
		
		int dieOneValue = randDice.getDie1().getLastRoll();
		int dieTwoValue = randDice.getDie2().getLastRoll();
		
		assertEquals(randDice.getLastRoll(), dieOneValue + dieTwoValue);
		
		int twoRoll = 0;
		int threeRoll = 0;
		int fourRoll = 0;
		int fiveRoll = 0;
		int sixRoll = 0;
		int sevenRoll = 0;
		int eightRoll = 0;
		int nineRoll = 0;
		int tenRoll = 0;
		int elevenRoll = 0;
		int twelveRoll = 0;
		int elseRoll = 0;
		
		for (int i = 0; i < 1000; i++) {
			randDice.roll();
			
			switch (randDice.getLastRoll()) {
			
			case 2:
				twoRoll++;
				break;
			case 3:
				threeRoll++;
				break;
			case 4:
				fourRoll++;
				break;
			case 5:
				fiveRoll++;
				break;
			case 6:
				sixRoll++;
				break;
			case 7:
				sevenRoll++;
				break;
			case 8:
				eightRoll++;
				break;
			case 9:
				nineRoll++;
				break;
			case 10:
				tenRoll++;
				break;
			case 11:
				elevenRoll++;
				break;
			case 12:
				twelveRoll++;
				break;
			default:
				elseRoll++;
				break;
			}
			
		}
		
		assertEquals(elseRoll, 0);
		assertTrue(twoRoll > 0);
		assertTrue(threeRoll > 0);
		assertTrue(fourRoll > 0);
		assertTrue(fiveRoll > 0);
		assertTrue(sixRoll > 0);
		assertTrue(sevenRoll > 0);
		assertTrue(eightRoll > 0);
		assertTrue(nineRoll > 0);
		assertTrue(tenRoll > 0);
		assertTrue(elevenRoll > 0);
		assertTrue(twelveRoll > 0);
		
	}

}
