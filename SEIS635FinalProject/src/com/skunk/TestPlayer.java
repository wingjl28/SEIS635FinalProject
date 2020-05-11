package com.skunk;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void test() {
		
		//create player
		Player playerOne = new Player("PlayerOne");
		
		//test name method
		assertEquals(playerOne.getPlayerName(), "PlayerOne");
		
		//test player score and chips after initial creation. should be 0 score and 100 chips
		assertEquals(playerOne.getChipCount(), 100);
		assertEquals(playerOne.getGameScore(), 0);
		
		//test adding score to player
		assertEquals(playerOne.getTurnScore(), 0);
		playerOne.addTurnScore(50);
		assertEquals(playerOne.getTurnScore(), 50);
		playerOne.addGameScore();
		assertEquals(playerOne.getGameScore(), 50);
		
		playerOne.newTurn();
		assertEquals(playerOne.getTurnScore(),0);
		assertEquals(playerOne.getGameScore(), 50);
			

	}
	
	@Test
	void single_skunk_test() {
		Player playerOne = new Player("PlayerOne");
		//add 50 to player score to test single skunk
		playerOne.addTurnScore(50);
		playerOne.addGameScore();
		
		//test single skunk: no change to player game score, 0 turn score, and -1 to chip count.
		playerOne.singleSkunk();
		
		assertEquals(playerOne.getChipCount(), 99);
		assertEquals(playerOne.getGameScore(), 50);
		assertEquals(playerOne.getTurnScore(), 0);
	}
	
	@Test
	void double_skunk_test() {
		Player playerOne = new Player("PlayerOne");
		//add 50 to player score to test single skunk
		playerOne.addTurnScore(50);
		playerOne.addGameScore();
		
		//test double skunk: 0 game score, 0 turn score, and -4 change to chip count.
		playerOne.doubleSkunk();
		
		assertEquals(playerOne.getChipCount(), 96);
		assertEquals(playerOne.getGameScore(), 0);
		assertEquals(playerOne.getTurnScore(), 0);
	}

	@Test
	void skunk_deuce_test() {
		Player skunkDeuce = new Player("PlayerOne");
		//add 50 to player score to test single skunk
		skunkDeuce.addTurnScore(50);
		skunkDeuce.addGameScore();
		
		//test double skunk: no change to player game score, 0 turn score, and -2 change to chip count.
		skunkDeuce.skunkDeuce();
		
		assertEquals(skunkDeuce.getChipCount(), 98);
		assertEquals(skunkDeuce.getGameScore(), 50);
		assertEquals(skunkDeuce.getTurnScore(), 0);
	}
}
