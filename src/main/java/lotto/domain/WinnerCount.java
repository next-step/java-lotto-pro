package lotto.domain;

public class WinnerCount {
	private int winnerCount;

	public WinnerCount(int winnerCount) {
		this.winnerCount = winnerCount;
	}

	public void plus() {
		winnerCount++;
	}

	public int value() {
		return winnerCount;
	}
}
