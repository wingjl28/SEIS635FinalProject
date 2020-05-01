import java.util.ArrayList;

import edu.princeton.cs.introcs.*;
/* Skunk App Game
 * 
 * SEIS 635 Project 1
 * Jonathan Vang
 * Jake Wing
 * 
 * 
 * */
public class SkunkApp {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Dice gameDice = new Dice();		
		GameController gameController = new GameController(players, gameDice);
	}

}
