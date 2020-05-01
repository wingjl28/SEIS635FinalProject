
public class Die
{
	private int lastRoll;
	private boolean predictable;

	public Die()
	{
		this.roll();
		this.predictable = false;
	}
	
	//constructor to set dice value for testing
	public Die(int diceValue)
	{
		lastRoll = diceValue;
		this.predictable = true;
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		if (!predictable)
			this.lastRoll = (int) (Math.random() * 6 + 1);
			
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}
	

}
