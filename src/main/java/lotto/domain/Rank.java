package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	LOSS(0, 0);

	public static final String MATCH_COUNT_NOT_CORRECT_ERROR = "일치하는 숫자의 개수가 올바르지 않습니다.";

	private int matchCount;
	private int prizeMoney;

	Rank(final int matchCount, final int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank from(final int matchCount) {
		if (matchCount < FIFTH.matchCount) {
			return LOSS;
		}

		return Arrays.stream(values())
			.filter(rank -> rank.isCountMatch(matchCount))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(MATCH_COUNT_NOT_CORRECT_ERROR));
	}

	public int matchCount() {
		return matchCount;
	}

	public int prizeMoney() {
		return prizeMoney;
	}

	private boolean isCountMatch(int matchCount) {
		return this.matchCount == matchCount;
	}
}
