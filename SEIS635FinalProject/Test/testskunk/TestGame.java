package testskunk;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.skunk.Game;

class TestGame {

	@Test
	void test_Game_constructor() {
		String playerOne = "PlayerOneName";
		String playerTwo = "PlayerTwoName";
		String playerThree = "PlayerThreeName";
		String playerFour = "PlayerFourName";
		String playerFive = "PlayerFiveName";
		String playerSix = "PlayerSixName";
		String playerSeven = "PlayerSevenName";
		String playerEight = "PlayerEightName";
		
		Game testFullGame = new Game(playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight);
		assertEquals(testFullGame.getPlayers().get(0).getPlayerName(),"PlayerOneName") ;
		assertEquals(testFullGame.getPlayers().get(1).getPlayerName(),"PlayerTwoName") ;
		assertEquals(testFullGame.getPlayers().get(2).getPlayerName(),"PlayerThreeName") ;
		assertEquals(testFullGame.getPlayers().get(3).getPlayerName(),"PlayerFourName") ;
		assertEquals(testFullGame.getPlayers().get(4).getPlayerName(),"PlayerFiveName") ;
		assertEquals(testFullGame.getPlayers().get(5).getPlayerName(),"PlayerSixName") ;
		assertEquals(testFullGame.getPlayers().get(6).getPlayerName(),"PlayerSevenName") ;
		assertEquals(testFullGame.getPlayers().get(7).getPlayerName(),"PlayerEightName") ;
		//there should be 8 players in the game
		assertEquals(testFullGame.getNumberOfPlayers(), 8);
		//game has started and current player is first player in player index
		assertEquals(testFullGame.getCurrentPlayer().getPlayerName(),"PlayerOneName") ;
		
		String playerOnePart = "PlayerOneName";
		String playerTwoPart = "PlayerTwoName";
		String playerThreePart = "PlayerThreeName";
		String playerFourPart = "PlayerFourName";
		String playerFivePart = "";
		String playerSixPart = "";
		String playerSevenPart = "";
		String playerEightPart = "";
		
		//test a game where only 4 players are involved
		Game testPartGame = new Game(playerOnePart, playerTwoPart, playerThreePart, playerFourPart, playerFivePart, playerSixPart, playerSevenPart, playerEightPart);
		
		assertEquals(testPartGame.getPlayers().get(0).getPlayerName(),"PlayerOneName") ;
		assertEquals(testPartGame.getPlayers().get(1).getPlayerName(),"PlayerTwoName") ;
		assertEquals(testPartGame.getPlayers().get(2).getPlayerName(),"PlayerThreeName") ;
		assertEquals(testPartGame.getPlayers().get(3).getPlayerName(),"PlayerFourName") ;
		//Four players in the game should be expected
		assertEquals(testPartGame.getNumberOfPlayers(), 4);
		//Game is created and current player should be the same player as index 0 in players array
		assertEquals(testPartGame.getCurrentPlayer().getPlayerName(),"PlayerOneName") ;
		
	}

	@Test
	void test_game_roll() {
		String playerOne = "PlayerOneName";
		String playerTwo = "PlayerTwoName";
		String playerThree = "PlayerThreeName";
		String playerFour = "PlayerFourName";
		String playerFive = "PlayerFiveName";
		String playerSix = "PlayerSixName";
		String playerSeven = "PlayerSevenName";
		String playerEight = "PlayerEightName";
		
		Game testGame = new Game(playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight);
		testGame.setDieRolls(5, 5);
		assertTrue(testGame.getCurrentPlayerName().equals("PlayerOneName"));
		assertEquals("10", testGame.rollTurn());
		assertEquals(10, testGame.getTurnScore());
		
		assertEquals("10", testGame.rollTurn());
		assertEquals(20, testGame.getTurnScore());
		
		assertEquals("10", testGame.rollTurn());
		assertEquals(30, testGame.getTurnScore());
		
		assertTrue(testGame.getCurrentPlayerName().equals("PlayerOneName"));
		assertEquals(0,testGame.getCurrentPlayer().getGameScore());
		assertEquals("PlayerOneName", testGame.getCurrentPlayerName());
		assertEquals(testGame.getNextPlayerName(), "PlayerTwoName");
		
		testGame.endTurn();
		assertEquals(30, testGame.getPlayers().get(0).getGameScore());
		assertEquals(0,testGame.getCurrentPlayer().getGameScore());
		assertEquals("PlayerTwoName",testGame.getCurrentPlayerName());
		assertEquals("PlayerThreeName",testGame.getNextPlayerName());
		
		
	}

	@Test
	void test_game_roll_skunk() {
		String playerOne = "PlayerOneName";
		String playerTwo = "PlayerTwoName";
		String playerThree = "PlayerThreeName";
		String playerFour = "PlayerFourName";
		String playerFive = "PlayerFiveName";
		String playerSix = "PlayerSixName";
		String playerSeven = "PlayerSevenName";
		String playerEight = "PlayerEightName";
		
		Game testGame = new Game(playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight);
		
		//test single skunk
		testGame.setDieRolls(1, 5);
		assertTrue(testGame.getCurrentPlayerName().equals("PlayerOneName"));
		testGame.getCurrentPlayer().addScore(20);
		assertEquals(testGame.getCurrentPlayer().getGameScore(),20);
		assertEquals("Single Skunk", testGame.rollTurn());
		//check to make sure player 1 (index 0) didnt get added score 
		assertEquals(testGame.getPlayers().get(0).getGameScore(),20);
		assertTrue(testGame.getCurrentPlayerName().equals("PlayerTwoName"));
		
		//test double skunk
		testGame.setDieRolls(1, 1);
		assertTrue(testGame.getCurrentPlayerName().equals("PlayerTwoName"));
		testGame.getCurrentPlayer().addScore(20);
		assertEquals(testGame.getCurrentPlayer().getGameScore(),20);
		assertTrue(testGame.rollTurn().equals("Double Skunk"));
		assertEquals(testGame.getPlayers().get(1).getGameScore(),0);
				
		//test skunk deuce
		assertTrue(testGame.getCurrentPlayerName().equals("PlayerThreeName"));
		testGame.getCurrentPlayer().addScore(10);
		assertEquals(testGame.getCurrentPlayer().getGameScore(),10);
		testGame.setDieRolls(1, 2);
		assertTrue(testGame.rollTurn().equals("Skunk Deuce"));
		assertEquals(testGame.getPlayers().get(2).getGameScore(),10);
		
		
		assertEquals("PlayerFourName",testGame.getCurrentPlayerName());
		assertEquals("PlayerFiveName",testGame.getNextPlayerName());
		
				assertTrue(testGame.rollTurn().equals("Skunk Deuce"));
		assertEquals("PlayerFiveName",testGame.getCurrentPlayerName());
		assertEquals("PlayerSixName",testGame.getNextPlayerName());
		
		assertTrue(testGame.rollTurn().equals("Skunk Deuce"));
		assertEquals("PlayerSixName",testGame.getCurrentPlayerName());
		assertEquals("PlayerSevenName",testGame.getNextPlayerName());
		
		assertTrue(testGame.rollTurn().equals("Skunk Deuce"));
		assertEquals("PlayerSevenName",testGame.getCurrentPlayerName());
		assertEquals("PlayerEightName",testGame.getNextPlayerName());
		
		assertTrue(testGame.rollTurn().equals("Skunk Deuce"));
		assertEquals("PlayerEightName",testGame.getCurrentPlayerName());
		assertEquals("PlayerOneName",testGame.getNextPlayerName());
		
		assertTrue(testGame.rollTurn().equals("Skunk Deuce"));
		assertEquals("PlayerOneName",testGame.getCurrentPlayerName());
		assertEquals("PlayerTwoName",testGame.getNextPlayerName());
		
	}
	

}
