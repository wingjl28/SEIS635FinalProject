import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class Game {
	private ArrayList<Player> players;
	ArrayList<Player> playersWithScoreOver100 = new ArrayList<Player>();
	private ArrayList<Turn> gameSeries;
	private int kittyCount = 0;
	private Dice gameDice;
	private boolean victory = false;
	
	Game(ArrayList<Player> players, int playerCount, Dice gameDice){
		this.players = players;
		this.gameDice = gameDice;
		//winners = new ArrayList<Player>();
		gameSeries = new ArrayList<Turn>();
		for (int i = 0; i < playerCount; i++) {
			players.add(new Player(GamePL.getPlayerName(i), 0, 50));
		}
	}
	
	public void startGame() {
		
		
	while (victory == false) {
		startSeries();
		checkForVictory();
		
	}
	
	players.forEach((player) -> {
		if (player.getScore() < 100) {
		Turn finalTurn = new Turn(player, gameDice);
		finalTurn.processTurns();
		gameSeries.add(finalTurn);
		checkForVictory();
		}}); 
		
	playersWithScoreOver100.forEach((player) -> {
		StdOut.println("The Winners are " + player.getPlayerName() + " with a score of: " + player.getScore());
	});
	
	};
	
	public void startSeries() {
		//start turn series
		players.forEach((player) -> {
			Turn newTurn = new Turn(player, gameDice);
			newTurn.processTurns();
			gameSeries.add(newTurn);
			kittyCount = kittyCount + newTurn.getChipsToKitty();
		}); 
		
	}
	
	public boolean checkForVictory() {
		players.forEach((player) -> {
			if (player.getScore() > 100 && playersWithScoreOver100.contains(player) == false ) {//
				playersWithScoreOver100.add(player);
			}
		}); 
		if (playersWithScoreOver100.size() > 0) { 
			victory = true;
			return true;
		}
		else 
			return false;
				
	}
	
}