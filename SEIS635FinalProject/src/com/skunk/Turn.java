package com.skunk;
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
	
	public String roll() {
		gameDice.roll();
		int rollResult = gameDice.getLastRoll();	
		int dieOneValue = gameDice.getDie1().getLastRoll();
		int dieTwoValue = gameDice.getDie2().getLastRoll();
		
		String rollOutput;
		//check to see if either die value is 1, if so make the roll value a 1.
		//with 2 die, 1 is never possible to overlap; therefore, this is okay because
		//this score will cause the turn score to become 0.
		if(dieOneValue == 1 && dieTwoValue > 2)
			rollResult = 1;
		if(dieTwoValue == 1 && dieOneValue > 2)
			rollResult = 1;
		
		switch (rollResult) {
		case 1: //singleSkunk, roll changed to 1 based off 2xdie values.
			player.singleSkunk();
			rollOutput = "Single Skunk";
			this.hasAnotherRoll = false;
			this.rollSequence.add(rollResult);
			this.turnScore = 0;
			break;
		case 2: //double skunk, as only a 1 for both die can result in a 2 score
			player.doubleSkunk();
			rollOutput = "Double Skunk";
			this.hasAnotherRoll = false;
			this.rollSequence.add(rollResult);
			this.turnScore = 0;
			break;
		case 3: //skunk deuce, as only a 1 or 2 for either die can result in a 3 score
			player.skunkDeuce();
			rollOutput = "Skunk Deuce";
			this.hasAnotherRoll = false;
			this.rollSequence.add(rollResult);
			this.turnScore = 0;
			break;
		default://actual roll value, as anything that isn't 2, 3, or forced 1 (single skunk) is a valid roll
			rollOutput = Integer.toString(rollResult);
			this.hasAnotherRoll = true;
			this.turnScore = this.turnScore + rollResult;
			this.rollSequence.add(rollResult);
		}
		
		return rollOutput;
	}
	
	
	public ArrayList<Integer> getRollSequence() {
		return rollSequence;
	}
	public void endTurn() {
		player.addScore(turnScore);
		this.rollSequence.clear();
		this.turnScore = 0;
	}

	public int getChipsToKitty() {
		return chipsToKitty;
	}
	
	public boolean hasAnotherRoll() {
		return this.hasAnotherRoll;
	}
	
	
}
