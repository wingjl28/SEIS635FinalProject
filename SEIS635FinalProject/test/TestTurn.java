import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void test_turnScore() {
		Player test_player_one = new Player("Player_One", 50, 50);
		//use two predictable dice to get turn score
		Die test_die = new Die(5);
		Dice test_dice = new Dice(test_die, test_die);
		Turn test_turn = new Turn(test_player_one, test_dice);
		test_turn.processRoll();
		test_turn.summarizeTurn();
		//two dice with a set value of 5 were used.
		assertEquals(test_turn.getTurnScore(), 10);
		
		test_turn.setTurnScore(15);
		assertEquals(test_turn.getTurnScore(), 15);

	}
	
	@Test
	void test_double_skunk() {
		Player test_player_one = new Player("Player_One", 50, 50);
		//use two predictable dice to get turn score
		//test DOUBLE Skunk
		Die test_die = new Die(1);
		Dice test_dice = new Dice(test_die, test_die);
		Turn test_turn = new Turn(test_player_one, test_dice);
		test_turn.setTurnScore(10);
		//ensure a turn score is added before its removed by double skunk
		assertEquals(test_turn.getTurnScore(), 10);
		test_turn.processRoll();
		
		assertEquals(test_turn.getChipsToKitty(),4);
		assertEquals(test_turn.getTurnScore(),0);
		
	}
	
	@Test
	void test_skunk_duece() {
		Player test_player_one = new Player("Player_One", 50, 50);
		//use two predictable dice to get turn score
		//test SKUNKDUECE
		Die test_die = new Die(1);
		Die test_die_two = new Die(2);
		Dice test_dice = new Dice(test_die, test_die_two);
		Turn test_turn = new Turn(test_player_one, test_dice);
		test_turn.setTurnScore(10);
		//ensure a turn score is added before its removed by skunk duece
		assertEquals(test_turn.getTurnScore(), 10);
		test_turn.processRoll();
		
		assertEquals(test_turn.getChipsToKitty(),2);
		assertEquals(test_turn.getTurnScore(),0);
	}
	
	@Test
	void test_single_skunk() {
		Player test_player_one = new Player("Player_One", 50, 50);
		//use two predictable dice to get turn score
		//test SKUNKDUECE
		Die test_die = new Die(1);
		Die test_die_two = new Die(3);
		Dice test_dice = new Dice(test_die, test_die_two);
		Turn test_turn = new Turn(test_player_one, test_dice);
		test_turn.setTurnScore(10);
		//ensure a turn score is added before its removed by single skunk
		assertEquals(test_turn.getTurnScore(), 10);
		test_turn.processRoll();
		
		assertEquals(test_turn.getChipsToKitty(),1);
		assertEquals(test_turn.getTurnScore(),0);
	}
	
	@Test
	void test_no_penalty() {
		Player test_player_one = new Player("Player_One", 50, 50);
		//use two predictable dice to get turn score
		//test SKUNKDUECE
		Die test_die = new Die(3);
		Dice test_dice = new Dice(test_die, test_die);
		Turn test_turn = new Turn(test_player_one, test_dice);
		test_turn.setTurnScore(10);
		//ensure a turn score is added before its removed by single skunk
		assertEquals(test_turn.getTurnScore(), 10);
		test_turn.processRoll();
		//rolling adds on die values to already sety turn score.
		assertEquals(test_turn.getChipsToKitty(),0);
		assertEquals(test_turn.getTurnScore(),16);
	}
}
