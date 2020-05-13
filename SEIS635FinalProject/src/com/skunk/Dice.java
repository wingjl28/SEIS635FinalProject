package com.skunk;

public class Dice
{

	private int lastRoll;
	private Die die1;
	private Die die2;
	
	Dice() {
		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	Dice(int dieOne, int dieTwo){
		this.die1 = new Die(dieOne);
		this.die2 = new Die(dieTwo);
		this.roll();
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}	

	public Die getDie1() {
		return die1;
	}

	public Die getDie2() {
		return die2;
	}
	
	public void setDie1(int newValue) {
		this.die1.setDieValue(newValue);
	}
	public void setDie2(int newValue) {
		this.die2.setDieValue(newValue);
	}

}
