import java.util.ArrayList;

public class Turn {
	private Player player;
	private int turnScore;
	private Dice gameDice;
	private ArrayList<Integer> rollSequence;
	private int chipsToKitty;
	private boolean hasAnotherRoll;
	
	Turn (Player player, Dice gameDice) {
		this.player = player;
		this.gameDice = gameDice;
		rollSequence = new ArrayList<Integer>();
		turnScore = 0;
		chipsToKitty = 0;
		hasAnotherRoll = true;
	}

	public int getTurnScore() {
		return turnScore;
	}

	public void setTurnScore(int turnScore) {
		this.turnScore = turnScore;
	}
	
	public void processTurns() {
		int turnSelection = TurnPL.getTurnSelection(player.getPlayerName());
		if (turnSelection == 1) {//1 = roll
			processRoll();
			if (hasAnotherRoll == true) {
				processTurns();
			} else {
				summarizeTurn();
			}
		} else { //2 = pass
			passTurn();
		}		
	}
	
	public void processRoll() {
		gameDice.roll();
		int rollValue = gameDice.getLastRoll();		
		if (gameDice.getSkunkType() == SkunkType.DOUBLE) { //double skunk
			player.doubleSkunk();
			turnScore = 0;
			chipsToKitty = 4;
			rollSequence.add(-4);
			hasAnotherRoll = false;
		} else if (gameDice.getSkunkType() == SkunkType.SKUNKDUECE) { // skunk deuce
			player.skunkDeuce();
			turnScore = 0;
			chipsToKitty = 2;
			rollSequence.add(-2);
			hasAnotherRoll = false;
		} else if (gameDice.getSkunkType() == SkunkType.SINGLE) { //single skunk
			player.singleSkunk();
			turnScore = 0;
			chipsToKitty = 1;
			rollSequence.add(-1);
			hasAnotherRoll = false;
		} else { //add score to turnScore
			turnScore = turnScore + rollValue;
			rollSequence.add(rollValue);
			hasAnotherRoll = true;
			//player.addScore(rollValue);
		}
		TurnPL.announceRollResult(player.getPlayerName(), gameDice.getDie1().getLastRoll(), gameDice.getDie2().getLastRoll(), gameDice.getSkunkType(), turnScore, player.getScore());
	}
	
	public void passTurn() {
		if (turnScore == 0) {
			TurnPL.announcePlayerPass(player.getPlayerName(), turnScore);
		} else {
			TurnPL.announcePlayerPass(player.getPlayerName(), turnScore);
			summarizeTurn();
		}
	}
	
	public void summarizeTurn() {
		player.addScore(turnScore);
		TurnPL.summarizeTurn(player.getPlayerName(), turnScore, chipsToKitty, rollSequence, player.getScore());		
	}

	public int getChipsToKitty() {
		return chipsToKitty;
	}
	
}
