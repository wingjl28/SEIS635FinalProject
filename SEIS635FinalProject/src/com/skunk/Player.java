package com.skunk;
public class Player {
	private int gameScore;
	private int chipCount;
	private String playerName;
	
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.gameScore = 0;
		this.chipCount = 100;
	}
	
	public void doubleSkunk() {
		this.gameScore = 0;
		this.chipCount = this.chipCount - 4;
	}
	
	public void singleSkunk () {
		this.chipCount = this.chipCount - 1;
	}
	
	public void skunkDeuce () {
		this.chipCount = this.chipCount - 2;
	}
	
	public void addScore(int turnScore) {
		this.gameScore = this.gameScore + turnScore;
	}
	

	public int getGameScore() {
		return gameScore;
	}
	

	public int getChipCount() {
		return chipCount;
	}
	
	public String getPlayerName() {
		return playerName;
	}

}