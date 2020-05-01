public class GamePL {
	
	public static String getPlayerName(int playerIndex) {
		StdOut.println("Please enter the name for player " + (playerIndex + 1));
		return StdIn.readString();	
	}
	
}
