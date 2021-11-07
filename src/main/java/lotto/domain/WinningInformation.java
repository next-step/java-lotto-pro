package lotto.domain;

public class WinningInformation {
	private final MatchedNumber matchedNumber;
	private final WinningAmount WinningAmount;
	private final WinnerCount winnerCount;

	public WinningInformation(int matchedNumber, int reward, int winnerCount) {
		this.matchedNumber = new MatchedNumber(matchedNumber);
		this.WinningAmount = new WinningAmount(reward);
		this.winnerCount = new WinnerCount(winnerCount);
	}

	public void addWinner() {
		winnerCount.plus();
	}

	public int getMatchedNumber() {
		return matchedNumber.value();
	}

	public int getWinningAmount() {
		return WinningAmount.value();
	}

	public int getWinnerCount() {
		return winnerCount.value();
	}
}
