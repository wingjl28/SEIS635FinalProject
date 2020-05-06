import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void test() {
		Player playerOne = new Player("PlayerOne");
		assertEquals(playerOne.getPlayerName(), "PlayerOne");
		
		playerOne.setScore(100);
		assertEquals(playerOne.getScore(), 100);
		
		playerOne.removeScore(100);
		assertEquals(playerOne.getScore(),0);
		
		playerOne.addScore(50);
		assertEquals(playerOne.getScore(), 50);
		
		playerOne.setChipCount(50);
		assertEquals(playerOne.getChipCount(), 50);
		
		playerOne.addChips(50);
		assertEquals(playerOne.getChipCount(), 100);
		
		playerOne.removeChips(100);
		assertEquals(playerOne.getChipCount(), 0);

	}

}
