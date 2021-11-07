package lotto.domain;

public class WinningAmount {
	private final int winningAmount;

	public WinningAmount(int winningAmount) {
		this.winningAmount = winningAmount;
	}

	public int value() {
		return winningAmount;
	}
}
