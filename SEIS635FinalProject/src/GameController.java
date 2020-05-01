import java.util.ArrayList;

public class GameController {
	private ArrayList<Player> players;
	private Dice gameDice;
	private int lastIntInput;
	private Game currentGame;
	private int playerNum;
	
	GameController (ArrayList<Player> players, Dice dice){
		this.players = players;
		gameDice = dice;
		startApp();
	}
	
	public void startApp() {
		SkunkPL.printWelcome();
		lastIntInput = SkunkPL.getSkunkStartNavigation();
		if (lastIntInput == 1) { //list rules
			listRules();
		} else if (lastIntInput == 2) { //start game
			beginGame();
		}
	}
	
	public void listRules() {
		SkunkPL.printRules();
		startApp();
	}
	
	public void beginGame() {
		lastIntInput = SkunkPL.getGameSelection();
		if (lastIntInput == 1) {
			currentGame = new Game(players, 2, gameDice);
			currentGame.startGame();
		} else if(lastIntInput == 2) {
			playerNum = SkunkPL.getPlayerNumber();
			currentGame = new Game(players, playerNum, gameDice);
			currentGame.startGame();
		}
	}
	
}
