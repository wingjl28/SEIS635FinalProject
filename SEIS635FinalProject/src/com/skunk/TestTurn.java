package com.skunk;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void testTurn() {
		
		Dice predDice = new Dice(5,5);
		Dice randDice = new Dice();
		Player testPlayer = new Player("testplayer");
		
		Turn testPredTurn = new Turn(testPlayer,predDice);
		Turn testRandTurn = new Turn(testPlayer, randDice);
		
		assertEquals(testPredTurn.getTurnScore(),0 );
		assertEquals(testRandTurn.getTurnScore(),0 );
		
	}

	@Test
	void testGetTurnScore() {
		Dice predDice = new Dice(5,5);
		Player testPlayer = new Player("testplayer");
		
		Turn testPredTurn = new Turn(testPlayer,predDice);
		testPredTurn.roll();
		assertEquals(testPredTurn.getTurnScore(), 10);
		testPredTurn.roll();
		assertEquals(testPredTurn.getTurnScore(), 20);
		predDice.setDie1(2);
		predDice.setDie2(2);
		testPredTurn.roll();
		assertEquals(testPredTurn.getTurnScore(), 24);
		predDice.setDie1(1);
		testPredTurn.roll();
		assertEquals(predDice.getDie1().getLastRoll(),1);
		assertEquals(testPredTurn.getTurnScore(), 0);
		
	}

	@Test
	void testSetTurnScore() {
		Dice predDice = new Dice(5,5);
		Player testPlayer = new Player("testplayer");
		
		Turn testPredTurn = new Turn(testPlayer,predDice);
		testPredTurn.setTurnScore(10);
		assertEquals(testPredTurn.getTurnScore(), 10);
		
		predDice.setDie1(1);
		testPredTurn.roll();
		assertEquals(predDice.getDie1().getLastRoll(),1);
		assertEquals(testPredTurn.getTurnScore(), 0);
	}

	@Test
	void testGetRollSequence() {
		Dice predDice = new Dice(5,5);
		Player testPlayer = new Player("testplayer");
		ArrayList<Integer> expectedSeq = new ArrayList<Integer>();
		expectedSeq.add(10);
		expectedSeq.add(10);
		Turn testPredTurn = new Turn(testPlayer,predDice);
		testPredTurn.roll();
		testPredTurn.roll();
		
		assertEquals(testPredTurn.getRollSequence(), expectedSeq);
		
		predDice.setDie1(2);
		predDice.setDie2(2);
		expectedSeq.add(4);
		testPredTurn.roll();
		assertEquals(testPredTurn.getRollSequence(), expectedSeq);

		//single skunk
		predDice.setDie1(1);
		predDice.setDie2(6);
		expectedSeq.add(1);
		testPredTurn.roll();
		assertEquals(testPredTurn.getRollSequence(), expectedSeq);

		//double skunk
		predDice.setDie1(1);
		predDice.setDie2(1);
		expectedSeq.add(2);
		testPredTurn.roll();
		assertEquals(testPredTurn.getRollSequence(), expectedSeq);
		
		//skunk deuce
		predDice.setDie1(2);
		predDice.setDie2(1);
		expectedSeq.add(3);
		testPredTurn.roll();
		assertEquals(testPredTurn.getRollSequence(), expectedSeq);
	
		
	}

	@Test
	void testEndTurn() {
		Dice predDice = new Dice(5,5);
		Player testPlayer = new Player("testplayer");
	
		Turn testPredTurn = new Turn(testPlayer,predDice);
		testPredTurn.roll();
		testPredTurn.roll();
		
		assertEquals(testPlayer.getGameScore(), 0);
		assertEquals(testPredTurn.getTurnScore(), 20);
		testPredTurn.endTurn();
		assertEquals(testPlayer.getGameScore(), 20);
		assertEquals(testPredTurn.getTurnScore(), 0);
		
		//double skunk
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 20);
		assertEquals(testPredTurn.getTurnScore(), 10);
		predDice.setDie1(1);
		predDice.setDie2(1);
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 0);
		assertEquals(testPredTurn.getTurnScore(), 0);

		//single skunk
		predDice.setDie1(5);
		predDice.setDie2(5);
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 0);
		assertEquals(testPredTurn.getTurnScore(), 10);
		testPredTurn.endTurn();
		assertEquals(testPlayer.getGameScore(), 10);
		assertEquals(testPredTurn.getTurnScore(), 0);
		testPredTurn.roll();
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 10);
		assertEquals(testPredTurn.getTurnScore(), 20);
		
		predDice.setDie1(1);
		predDice.setDie2(5);
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 10);
		assertEquals(testPredTurn.getTurnScore(), 0);
		
		//skunk Deuce
		predDice.setDie1(5);
		predDice.setDie2(5);
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 10); //this is from single skunk test where we ended with 10 game score
		assertEquals(testPredTurn.getTurnScore(), 10);
		testPredTurn.endTurn();
		assertEquals(testPlayer.getGameScore(), 20);
		assertEquals(testPredTurn.getTurnScore(), 0);
		testPredTurn.roll();
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 20);
		assertEquals(testPredTurn.getTurnScore(), 20);
		
		predDice.setDie1(1);
		predDice.setDie2(2);
		testPredTurn.roll();
		assertEquals(testPlayer.getGameScore(), 20);
		assertEquals(testPredTurn.getTurnScore(), 0);
		
		
		
	}


}
