package com.skunk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Game {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> playersWithScoreOver100 = new ArrayList<Player>();
	private ArrayList<Player> playersWithScoreUnder100 = new ArrayList<Player>();
	private ArrayList<Player> noMoreRolls = new ArrayList<Player>();
	private ArrayList<Player> scoreOrder = new ArrayList<Player>();
	
	private Dice gameDice;
	
	private int currentPlayerIndex;
	private int numberOfPlayers;
	private int kittyCount = 0;
	
	private Player currentPlayer;
	private Player nextPlayer;
	private Player previousPlayer;
	private Player winner;
	
	private boolean finalTurn = false;
	private boolean victory = false;
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
				this.players.add(tempPlayers[i]);
				this.scoreOrder.add(tempPlayers[i]);
			}
		}
		
		this.numberOfPlayers = players.size();
		
	//-----HERE FOR RANDOM VS PREDICTABLE GAME------
		//----RANDOM GAME--------
			this.gameDice = new Dice();	
		//----END RANDOM GAME---------
			
		//----ADDING 10 EACH SCORE-----
			//this.gameDice = new Dice(5,5);
		//----END ADDING 10 EACH SCORE----
		
		//---DOUBLE SKUNK GAME--------
			//this.gameDice = new Dice(1,1);
			//this.players.get(0).addScore(50);
			//this.players.get(1).addScore(20);
		//----END DOUBLE SKUNK GAME-----
			
		//----SINGLE SKUNK GAME----
			//this.gameDice = new Dice(1,6);
			//this.players.get(0).addScore(50);
			//this.players.get(1).addScore(20);
		//----END SINGLE SKUNK GAME-----
			
		//----SKUNK DEUCE GAME---------
			//this.gameDice = new Dice(1,2);
			//this.players.get(0).addScore(50);
			//this.players.get(1).addScore(20);
		//----END SKUNK DEUCE GAME
		
	// ---------END PREDICTABLE/RANDOM GAME MODE---------------------
			
		this.currentPlayerIndex = 0;
		this.currentPlayer = players.get(currentPlayerIndex);
	}
	
	//testable Game constructor
	
public Game(boolean predictable, int dieValues,  String playerOneName, String playerTwoName, String playerThreeName, String playerFourName, String playerFiveName, String playerSixName, String playerSevenName, String playerEightName){
		
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
				this.players.add(tempPlayers[i]);
				this.scoreOrder.add(tempPlayers[i]);
			}
		}
		
		this.numberOfPlayers = players.size();
		
	//-----HERE FOR RANDOM VS PREDICTABLE GAME------
		//----RANDOM GAME--------
			this.gameDice = new Dice(dieValues,dieValues);	
		//----END RANDOM GAME---------
			
		//----ADDING 10 EACH SCORE-----
			//this.gameDice = new Dice(5,5);
		//----END ADDING 10 EACH SCORE----
		
		//---DOUBLE SKUNK GAME--------
			//this.gameDice = new Dice(1,1);
			//this.players.get(0).addScore(50);
			//this.players.get(1).addScore(20);
		//----END DOUBLE SKUNK GAME-----
			
		//----SINGLE SKUNK GAME----
			//this.gameDice = new Dice(1,6);
			//this.players.get(0).addScore(50);
			//this.players.get(1).addScore(20);
		//----END SINGLE SKUNK GAME-----
			
		//----SKUNK DEUCE GAME---------
			//this.gameDice = new Dice(1,2);
			//this.players.get(0).addScore(50);
			//this.players.get(1).addScore(20);
		//----END SKUNK DEUCE GAME
		
	// ---------END PREDICTABLE/RANDOM GAME MODE---------------------
			
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
		if(finalTurn)
			addFinishedPlayer(this.currentPlayer);
		if(this.currentPlayer.getGameScore() >= 100 && this.noMoreRolls.contains(this.currentPlayer)==false) {
			addFinishedPlayer(this.currentPlayer);
			this.finalTurn = true;
		}
	
		
		if(this.noMoreRolls.size() >= this.players.size())
			this.victory = true;
		
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
	
	public void addFinishedPlayer(Player player) {
		this.noMoreRolls.add(player);
	}
	
	public ArrayList<Player> getFinishedPlayers(){	
		return this.noMoreRolls;
	}
	
	public boolean getVictory() {
		return this.victory;
	}
	public boolean checkForVictory() {
		
		for(int i = 0; i < this.players.size(); i++) {
			if(this.players.get(i).getGameScore() >= 100) {
				this.playersWithScoreOver100.add(this.players.get(i));
				this.victory = true;
			}
		}
			
			return this.victory;
	}
	
	public Player getWinner(){
		Player winner = new Player("tempWinner");
		int winningScore = 0;
		
		for(int i = 0; i < this.players.size(); i++) {
			if(this.players.get(i).getGameScore() > winningScore) {
				winningScore = this.players.get(i).getGameScore();
				winner = this.players.get(i);
			}
		}
		
		return winner;
	}
	
	public boolean getFinalTurn() {
		return this.finalTurn;
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
	
//	public Turn getTurn() {
//		return this.gameTurn;
//	}
	
	public ArrayList<Player> getPlayerScoreOrder(){
	
		  Collections.sort(scoreOrder, new Comparator<Player>() {
		        @Override public int compare(Player p1, Player p2) {
		            return p2.getGameScore() - p1.getGameScore(); // Descending
		        }

		    });
		
		return scoreOrder;
		  
	}
}