package step3.winner;

public enum WinningAmount {
	THREE(3, 5_000, "3개 일치 (5000원)-"),
	FOUR(4, 50_000, "4개 일치 (50000원)-"),
	FIVE(5, 1_500_000, "5개 일치 (1500000원)-"),
	SIX(6, 2_000_000_000, "6개 일치 (2000000000원)-");

	private final int matchNumber;
	private final int amount;
	private final String message;

	WinningAmount(int matchNumber, int WinningAmount, String message) {
		this.matchNumber = matchNumber;
		this.amount = WinningAmount;
		this.message = message;
	}

	public int getMatch() {
		return matchNumber;
	}

	public int getAmount() {
		return amount;
	}

	public String getMessage() {
		return message;
	}

	public static int valueOf(int matchNumber) {
		switch (matchNumber) {
			case 3 :
				return THREE.getAmount();
			case 4 :
				return FOUR.getAmount();
			case 5 :
				return FIVE.getAmount();
			case 6 :
				return SIX.getAmount();
			default :
				return 0;
		}
	}
}
