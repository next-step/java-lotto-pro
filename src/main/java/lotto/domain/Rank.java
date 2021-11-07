package lotto.domain;

public enum Rank {
	FIRST_PLACE(6, "200_000_000_000"),
	SECOND_PLACE(5, "1_500_000"),
	THIRD_PLACE(4, "50_000"),
	FOURTH_PLACE(3, "5_000"),
	FAILED(0, "0");

	public static final String UNDER_BAR = "_";

	private final long matchCount;
	private final String prizeMoney;

	Rank(int matchCount, String prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank rank(long matchCount) {
		if (isFirstPlace(matchCount)) {
			return FIRST_PLACE;
		}
		if (isSecondPlace(matchCount)) {
			return SECOND_PLACE;
		}
		if (isThirdPlace(matchCount)) {
			return THIRD_PLACE;
		}
		if (isFourthPlace(matchCount)) {
			return FOURTH_PLACE;
		}
		return FAILED;
	}

	private static boolean isFourthPlace(long matchCount) {
		return FOURTH_PLACE.matchCount == matchCount;
	}

	private static boolean isThirdPlace(long matchCount) {
		return THIRD_PLACE.matchCount == matchCount;
	}

	private static boolean isSecondPlace(long matchCount) {
		return SECOND_PLACE.matchCount == matchCount;
	}

	private static boolean isFirstPlace(long matchCount) {
		return FIRST_PLACE.matchCount == matchCount;
	}

	public double getPrizeMoney() {
		return Double.parseDouble(this.prizeMoney.replace(UNDER_BAR, ""));
	}

	public long getMatchCount() {
		return matchCount;
	}
}
