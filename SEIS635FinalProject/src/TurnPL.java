import java.util.ArrayList;

import edu.princeton.cs.introcs.*;

public class TurnPL {
	
	public static int getTurnSelection(String playerName) {
		StdOut.println("It is " + playerName + "'s turn.");
		StdOut.println("Please select a turn option:");
		StdOut.println("1. Roll");
		StdOut.println("2. Pass");
		return StdIn.readInt();
	}
	
	public static int getTurnSelection(String playerName, boolean additionalRoll) {
		if (additionalRoll == true) {
			StdOut.println("It is still" + playerName + "'s turn.");
			StdOut.println("Please select a turn option:");
			StdOut.println("1. Roll");
			StdOut.println("2. Pass");
			return StdIn.readInt();
		} else {
			return getTurnSelection(playerName);
		}		
	}
		
	public static void announceRollResult(String playerName, int dice1Value, int dice2Value, SkunkType skunkType, int turnScore, int playerScore) {
		StdOut.println(playerName + " has rolled a " + dice1Value + " and a " + dice2Value);
		if (skunkType == SkunkType.SINGLE) {
			StdOut.println("There is a single skunk and as a result your turn has ended.");
			StdOut.println("");
		} else if (skunkType == SkunkType.DOUBLE) {
			StdOut.println("There is a double skunk and as a result your turn has ended.");
			StdOut.println("");
		} else if (skunkType == SkunkType.SKUNKDUECE) {
			StdOut.println("There is a skunk duece and as a result your turn has ended.");
			StdOut.println("");
		} else {
			StdOut.println("The turn score total is now " + turnScore);	
			StdOut.println("");
		}		
	}
	
	public static void announcePlayerPass(String playerName, int turnScore) {
		if (turnScore == 0) {
			StdOut.println(playerName + " has chosen to pass without rolling.");
		} else {
			StdOut.println(playerName + " has chosen to pass.");
			StdOut.println("");

		}
	}
	
	public static void summarizeTurn(String playerName, int turnScore, int chipsLost, ArrayList<Integer> rollSequence, int playerScore) {

		StdOut.println(playerName + "'s turn summary:");
		for (int i=0; i < rollSequence.size(); i++) {
			if (rollSequence.get(i) == -4) {
				StdOut.println("Roll " + (i + 1) + ": double skunk");
			} else if (rollSequence.get(i) == -2) {
				StdOut.println("Roll " + (i + 1) + ": skunk duece");
			} else if (rollSequence.get(i) == -1) {
				StdOut.println("Roll " + (i + 1) + ": single skunk");
			} else {
				StdOut.println("Roll " + (i + 1) + ": " + rollSequence.get(i));
			}	
		}
		StdOut.println("Total turn score: " + turnScore);
		StdOut.println("Total player score: " + playerScore);
		StdOut.println("Total chips lost: " + chipsLost);
		StdOut.println("");
	}
}
