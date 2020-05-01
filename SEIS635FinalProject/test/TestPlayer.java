import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void test_doubleSkunk() {
		//Expect to see score set to 0, regardless of value, and chip count to decrease by 4.
		
		Player testPlayerOne = new Player("TestPlayer1", 50, 50);
		testPlayerOne.doubleSkunk();
		assertEquals(testPlayerOne.getScore(),0);
		assertEquals(testPlayerOne.getChipCount(),46);
		
		Player testPlayerTwo = new Player("TestPlayer2", 101, 0);
		testPlayerTwo.doubleSkunk();
		assertEquals(testPlayerTwo.getScore(),0);
		assertEquals(testPlayerTwo.getChipCount(),-4); //Probably shouldn't allow for negative chip count?
		
		Player testPlayerThree = new Player("TestPlayer3", 0, 101);
		testPlayerThree.doubleSkunk();
		assertEquals(testPlayerThree.getScore(),0);
		assertEquals(testPlayerThree.getChipCount(),97);
	}
	@Test
	void test_singleSkunk() {
		//Expect to see chip count decrease by 1 chip and no change in score.
		
		Player testPlayerOne = new Player("TestPlayer1", 50, 50);
		testPlayerOne.singleSkunk();
		assertEquals(testPlayerOne.getScore(),50);
		assertEquals(testPlayerOne.getChipCount(),49);
		
		Player testPlayerTwo = new Player("TestPlayer2", 101, 0);
		testPlayerTwo.singleSkunk();
		assertEquals(testPlayerTwo.getScore(),101);
		assertEquals(testPlayerTwo.getChipCount(),-1); //Probably shouldn't allow for negative chip count?
		
		Player testPlayerThree = new Player("TestPlayer3", 0, 101);
		testPlayerThree.singleSkunk();
		assertEquals(testPlayerThree.getScore(),0); //Probably shouldn't allow for a negative score?
		assertEquals(testPlayerThree.getChipCount(),100);
	}
	
	@Test
	void test_skunkDeuce() {
		//Expect to see chip count decrease by 2 chip and no change in score.
		//Also tests "getChipCount() and getScore() methods.
		
		Player testPlayerOne = new Player("TestPlayer1", 50, 50);
		testPlayerOne.skunkDeuce();
		assertEquals(testPlayerOne.getScore(),50);
		assertEquals(testPlayerOne.getChipCount(),48);
		
		Player testPlayerTwo = new Player("TestPlayer2", 101, 0);
		testPlayerTwo.skunkDeuce();
		assertEquals(testPlayerTwo.getScore(),101);
		assertEquals(testPlayerTwo.getChipCount(),-2); //Probably shouldn't allow for negative chip count?
		
		Player testPlayerThree = new Player("TestPlayer3", 0, 101);
		testPlayerThree.skunkDeuce();
		assertEquals(testPlayerThree.getScore(),0); //Probably shouldn't allow for a negative score?
		assertEquals(testPlayerThree.getChipCount(),99);
	}
	
	@Test
	void test_playerName() {
		//Test to get player name		
		Player testPlayerOne = new Player("TestPlayer1", 50, 50);
		assertEquals(testPlayerOne.getPlayerName(),"TestPlayer1");
		
		testPlayerOne.setPlayerName("TestPlayer1_Change");
		assertEquals(testPlayerOne.getPlayerName(),"TestPlayer1_Change");
		
	}
	
	@Test
	void test_Score()	{
		//Test score modification
		Player testPlayer = new Player();
		testPlayer.setScore(50);
		assertEquals(testPlayer.getScore(),50);
		
		testPlayer.addScore(10);
		assertEquals(testPlayer.getScore(), 60);
	}
	
	@Test
	void test_chipCount()	{
		//Test chip count modification
		Player testPlayer = new Player();
		assertEquals(testPlayer.getChipCount(),100);
		
		testPlayer.setChipCount(50);
		assertEquals(testPlayer.getChipCount(), 50);
	}
	
}
