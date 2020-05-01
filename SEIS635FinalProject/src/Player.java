public class Player {
	private int score;
	private int chipCount;
	private String playerName;
	
	Player () {
		score = 0;
		chipCount = 100;
	}

	Player (String playerName, int score, int chipCount) {
		this.playerName = playerName;
		this.score =  score;
		this.chipCount = chipCount;
	}
	
	public void doubleSkunk() {
		score = 0;
		chipCount = chipCount - 4;
	}
	
	public void singleSkunk () {
		chipCount = chipCount - 1;
	}
	
	public void skunkDeuce () {
		chipCount = chipCount - 2;
	}
	
	public void addScore(int diceAmount) {
		score = score + diceAmount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getChipCount() {
		return chipCount;
	}

	public void setChipCount(int chipCount) {
		this.chipCount = chipCount;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}