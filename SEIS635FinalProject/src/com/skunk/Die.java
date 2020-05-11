package com.skunk;

public class Die
{
	private int lastRoll;
	private boolean predictable;

	public Die()
	{
		this.roll();
		this.predictable = false;
	}
	
	
	public Die(int diceValue)
	{
		lastRoll = diceValue;
		this.predictable = true;
	}

	public int getLastRoll() 
	{

		return this.lastRoll;
	}

	public void roll() 
	{
		if (!predictable)
			this.lastRoll = (int) (Math.random() * 6 + 1);
			
	}


}
