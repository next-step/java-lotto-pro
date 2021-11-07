package lotto.domain;

public enum Rank {

	FIFTH(3, 5000),
	FOURTH(4, 50000),
	THIRD(5, 1500000),
	FIRST(6, 2000000000);

	private final int matchedNumber;
	private final int winningAmount;

	Rank(int matchedNumber, int winningAmount) {
		this.matchedNumber = matchedNumber;
		this.winningAmount = winningAmount;
	}

	public int getMatchedNumber() {
		return matchedNumber;
	}

	public int getWinningAmount() {
		return winningAmount;
	}
}
