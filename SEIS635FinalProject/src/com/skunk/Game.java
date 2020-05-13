package com.skunk;
import java.util.ArrayList;


public class Game {
	private ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Player> playersWithScoreOver100 = new ArrayList<Player>();
	private ArrayList<Turn> gameSeries;
	private int kittyCount = 0;
	private Dice gameDice;
	private boolean victory = false;
	private int currentPlayerIndex;
	private int numberOfPlayers;
	private Player currentPlayer;
	private Player nextPlayer;
	private Player previousPlayer;
	private boolean rollAgain = true;
	private Turn gameTurn = null;
	
	//Take max amount of players, even if they are empty 
	public Game(String playerOneName, String playerTwoName, String playerThreeName, String playerFourName, String playerFiveName, String playerSixName, String playerSevenName, String playerEightName){
		
		Player playerOne = new Player(playerOneName);
		Player playerTwo = new Player(playerTwoName);
		Player playerThree = new Player(playerThreeName);
		Player playerFour = new Player(playerFourName);
		Player playerFive = new Player(playerFiveName);
		Player playerSix = new Player(playerSixName);
		Player playerSeven = new Player(playerSevenName);
		Player playerEight = new Player(playerEightName);
		
		//Add players to a temporary array to be analyzed for presence of players
		Player[] tempPlayers = new Player[8];
		tempPlayers[0] = playerOne;
		tempPlayers[1] = playerTwo;
		tempPlayers[2] = playerThree;
		tempPlayers[3] = playerFour;
		tempPlayers[4] = playerFive;
		tempPlayers[5] = playerSix;
		tempPlayers[6] = playerSeven;
		tempPlayers[7] = playerEight;

		for (int i = 0; i < tempPlayers.length; i++) {
			if (!(tempPlayers[i].getPlayerName().isEmpty())) {
				players.add(tempPlayers[i]);
			}
		}
		
		this.numberOfPlayers = players.size();
		this.gameDice = new Dice();	
		this.currentPlayerIndex = 0;
		this.currentPlayer = players.get(currentPlayerIndex);
	}
	
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
	
	public String rollTurn() {
		//decision of 1 is to roll, 0 is to skip
		//if start of turn, make a new turn
		String rollOutput = "";
		if(this.gameTurn == null)
			gameTurn = new Turn(currentPlayer, gameDice);
		rollOutput = gameTurn.roll();
		if(this.currentPlayerIndex == players.size())
			this.currentPlayerIndex =0;
		this.rollAgain = gameTurn.hasAnotherRoll();
		if (gameTurn.hasAnotherRoll() == false)
			endTurn();
		return rollOutput;
				
	}
	
	public void endTurn() {
		if (gameTurn != null)
			this.gameTurn.endTurn();
		this.currentPlayerIndex++;
		if(this.currentPlayerIndex == players.size())
			this.currentPlayerIndex =0;
		this.currentPlayer = getCurrentPlayer();
		this.nextPlayer = getNextPlayer();
		this.gameTurn = null;
		this.rollAgain = false;
	}
	
	public int getTurnScore() {
		if(gameTurn ==null)
			return 0;
		else
			return gameTurn.getTurnScore();
	}

	public void startSeries() {
		//start turn series
		players.forEach((player) -> {
			Turn newTurn = new Turn(player, gameDice);
			//newTurn.processTurns();
			gameSeries.add(newTurn);
			kittyCount = kittyCount + newTurn.getChipsToKitty();
		}); 
		
	}
	
	public boolean checkForVictory() {
		players.forEach((player) -> {
			if (player.getGameScore() > 100 && playersWithScoreOver100.contains(player) == false ) {//
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
	
	public String getCurrentPlayerName() {
		this.currentPlayer = players.get(currentPlayerIndex);
		return this.currentPlayer.getPlayerName();
	}
	
	public Player getCurrentPlayer() {
		this.currentPlayer = players.get(currentPlayerIndex);
		return this.currentPlayer;
	}
	
	public Player getNextPlayer() {
		if(currentPlayerIndex == players.size()-1)
			this.nextPlayer = players.get(0);
		else
			this.nextPlayer = players.get(currentPlayerIndex+1);
		return this.nextPlayer;
	}
	
	public Player getPreviousPlayer() {
		if(currentPlayerIndex == 0)
			this.previousPlayer = players.get(this.numberOfPlayers-1);
		else
			this.previousPlayer = players.get(currentPlayerIndex-1);
		return this.previousPlayer;
	}
	
	public String getNextPlayerName() {
		int nextIndex = currentPlayerIndex+1;
		if (nextIndex >= players.size())
			nextIndex =0;
		this.nextPlayer = players.get(nextIndex);
		
		return this.nextPlayer.getPlayerName();
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public boolean rollAgain() {
		return this.rollAgain;
	}
	
	public void setDieRolls(int dieOne, int dieTwo) {
		this.gameDice = new Dice(dieOne,dieTwo);
		this.gameTurn = new Turn(currentPlayer, this.gameDice);
	}
	
	public Turn getTurn() {
		return this.gameTurn;
	}
}