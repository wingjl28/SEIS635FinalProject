package com.skunk;
public class Player {
	private int gameScore;
	private int turnScore;
	private int chipCount;
	private String playerName;
	
	Player(String playerName) {
		this.playerName = playerName;
		this.gameScore = 0;
		this.turnScore = 0;
		this.chipCount = 100;
	}
	
	public void doubleSkunk() {
		this.gameScore = 0;
		this.turnScore = 0;
		this.chipCount = this.chipCount - 4;
	}
	
	public void singleSkunk () {
		this.chipCount = this.chipCount - 1;
		this.turnScore = 0;
	}
	
	public void skunkDeuce () {
		this.chipCount = this.chipCount - 2;
		this.turnScore = 0;
	}
	
	public void addGameScore() {
		this.gameScore = this.gameScore + this.turnScore;
	}
	
	public void addTurnScore(int dicevalue) {
		this.turnScore = this.turnScore + dicevalue;
	}

	public int getGameScore() {
		return gameScore;
	}
	
	public int getTurnScore() {
		return turnScore;
	}

	public int getChipCount() {
		return chipCount;
	}
	
	public String getPlayerName() {
		return playerName;
	}


	public void newTurn() {
		this.turnScore = 0;
	}

}