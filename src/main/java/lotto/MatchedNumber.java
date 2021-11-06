package lotto;

public class MatchedNumber {
	private static final int WINNER_MIN_BOUNDARY_VALUE = 3;
	private final int matchedNumber;

	public MatchedNumber(int matchedNumber) {
		this.matchedNumber = matchedNumber;
	}

	public int value() {
		return matchedNumber;
	}

	public boolean isWinner() {
		if (matchedNumber >= WINNER_MIN_BOUNDARY_VALUE) {
			return true;
		}
		return false;
	}
}
