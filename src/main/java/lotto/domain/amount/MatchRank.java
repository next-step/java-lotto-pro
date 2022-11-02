package lotto.domain.amount;

import java.util.Arrays;

public enum MatchRank {
	THREE_MATCH(3, 5000L),
	FOUR_MATCH(4, 50000L),
	FIVE_MATCH(5, 1500000L),
	SIX_MATCH(6, 2000000000L);

	public static final long NO_WINNING_PRICE = 0;

	private final int matchCount;
	private final long winningPrice;

	MatchRank(int matchCount, long winningPrice) {
		this.matchCount = matchCount;
		this.winningPrice = winningPrice;
	}

	public static long getWinningPrice(int matchCount) {
		return Arrays.stream(MatchRank.values())
			.filter(matchRank -> matchRank.hasMatchCount(matchCount))
			.findAny()
			.map(matchRank -> matchRank.winningPrice)
			.orElse(NO_WINNING_PRICE);
	}

	private boolean hasMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int getMatchCount() {
		return matchCount;
	}
}
