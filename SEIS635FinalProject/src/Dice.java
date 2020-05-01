public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;
	private SkunkType skunkType;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	public Dice(Die die1, int die1Value, Die die2, int die2Value) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
		
		this.lastRoll = die1Value + die2Value;
		
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		die1.roll();
		die2.roll();
		setSkunkType(die1,die2);
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}	

	public Die getDie1() {
		return die1;
	}

	public Die getDie2() {
		return die2;
	}

	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}
	
	private void setSkunkType(Die die1, Die die2) {
		if (die1.getLastRoll() == 1 && die2.getLastRoll() == 1) {
			skunkType = SkunkType.DOUBLE;
		} else if ((die1.getLastRoll() == 1 && die2.getLastRoll() != 2) || (die2.getLastRoll() == 1 && die1.getLastRoll() != 2)) {
			skunkType = SkunkType.SINGLE;
		} else if ((die1.getLastRoll() == 1 && die2.getLastRoll() == 2) || (die2.getLastRoll() == 1 && die1.getLastRoll() == 2)) {
			skunkType = SkunkType.SKUNKDUECE;
		} else {
			skunkType = SkunkType.NONE;
		}		
	}
	
	public SkunkType getSkunkType() {
		return skunkType;
	}
}
