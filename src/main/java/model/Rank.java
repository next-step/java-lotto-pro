package model;

public enum Rank {
	FIRST(2000000000),
	THIRD(1500000),
	FOURTH(50000),
	FIFTH(5000),
	NONE(0)
	;

	private final int reward;

	Rank(int reward) {
		this.reward = reward;
	}

	public int getReward() {
		return reward;
	}
}
