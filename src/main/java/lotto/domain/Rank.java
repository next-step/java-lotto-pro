package lotto.domain;

public enum Rank {

	MISS(0,0),
	FIFTH(3, 5000),
	FOURTH(4, 50000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),
	FIRST(6, 2000000000);

	private final int countOfMatch;
	private final int winningAmount;

	Rank(int countOfMatch, int winningAmount) {
		this.countOfMatch = countOfMatch;
		this.winningAmount = winningAmount;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningAmount() {
		return winningAmount;
	}
}
