package com.skunk;
import edu.princeton.cs.introcs.*;

public class SkunkPL {
	
	public static void printWelcome() {
		StdOut.println("");
		StdOut.println("*********************************");
		StdOut.println("  Welcome to the Skunk Game App");
		StdOut.println("*********************************");
		StdOut.println("");		
	}
	
	public static int getSkunkStartNavigation() {
		StdOut.println("Skunk Navigation:");
		StdOut.println("1. Read rules");
		StdOut.println("2. Start a game");
		StdOut.println("");		
		return StdIn.readInt();
	}
	
	public static void printRules() {
		StdOut.println("");		
		StdOut.println("The object of the game is to accumulate a score of 100 points or more.");
		StdOut.println("A score is made by rolling the dice and combining the points on the two dice.");
		StdOut.println("For example: A 4 and 5 would be 9 points");
		StdOut.println("");
		StdOut.println("If the player decides to take another roll of the dice and turns up a 3 and 5 (8 points)");
		StdOut.println("he/she would then have an accumulated total of 17 points for the two rolls");
		StdOut.println("The player has the privilege of continuing to shake to increase his score or of passing ");
		StdOut.println("the dice to wait for the next series, thus preventing the possibility of rolling a Skunk");
		StdOut.println("and losing his/her score.");
		StdOut.println("");
		StdOut.println("A skunk in any series voids the score for that series only and draws a penalty of");
		StdOut.println("1 chip placed in the \"kitty,\" and loss of dice.");
		StdOut.println("A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips");
		StdOut.println("placed in the \"kitty,\" and loss of dice.");
		StdOut.println("");
		StdOut.println("TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed");
		StdOut.println("in the \"kitty,\" and loss of dice. Player must again start to score from scratch.");
		StdOut.println("");
		StdOut.println("Any number can play. [Assume at least two players!] The suggested number of chips ");
		StdOut.println("to start is 50.");
		StdOut.println("");
		StdOut.println("The first player to accumulate a total of 100 or more points can continue to score as many");
		StdOut.println("points over 100 as he believes is needed to win. When he decides to stop, his total score");
		StdOut.println("is the goal. Each succeeding player receives one more chance to better the goal and end the game.");
		StdOut.println("");
		StdOut.println("The winner of each game collects all chips in \"kitty\" and in addition five chips");
		StdOut.println("from each losing player or 10 chips from any player without a score.");
		StdOut.println("");
	}
	
	public static int getGameSelection() {
		StdOut.println("");
		StdOut.println("Please select the type of game:");
		StdOut.println("1. Quick play (two players 50 chips each)");
		StdOut.println("2. 1-8 players with names and 50 chips");	
		return StdIn.readInt();
	}

	public static int getPlayerNumber() {
		StdOut.println("");
		StdOut.println("Enter the Number of Players:");
		return StdIn.readInt();
	}
	
}
