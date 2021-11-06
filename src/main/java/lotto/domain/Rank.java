package lotto.domain;

public enum Rank {
	FIRST_PLACE(6, "200_000_000_000"),
	SECOND_PLACE(5, "1_500_000"),
	THIRD_PLACE(4, "50_000"),
	FOURTH_PLACE(3, "5_000"),
	FAILED(0, "0");

	private final int matchCount;
	private final String prizeMoney;

	Rank(int matchCount, String prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank rank(int matchCount) {
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

	private static boolean isFourthPlace(int matchCount) {
		return FOURTH_PLACE.matchCount == matchCount;
	}

	private static boolean isThirdPlace(int matchCount) {
		return THIRD_PLACE.matchCount == matchCount;
	}

	private static boolean isSecondPlace(int matchCount) {
		return SECOND_PLACE.matchCount == matchCount;
	}

	private static boolean isFirstPlace(int matchCount) {
		return FIRST_PLACE.matchCount == matchCount;
	}

	public String getPrizeMoney() {
		return this.prizeMoney.replace("_", "");
	}
}
