package lotto.domain.lotto;

import java.util.Arrays;

public enum MatchRank {
	FAILED(0, 0L),
	THREE_MATCH(3, 5_000L),
	FOUR_MATCH(4, 50_000L),
	FIVE_MATCH(5, 1_500_000L),
	SIX_MATCH(6, 2_000_000_000L);

	private final int matchCount;
	private final long winningPrice;

	MatchRank(int matchCount, long winningPrice) {
		this.matchCount = matchCount;
		this.winningPrice = winningPrice;
	}

	public static MatchRank valueOfMatchCount(int matchCount) {
		return Arrays.stream(MatchRank.values())
			.filter(matchRank -> matchRank.hasMatchCount(matchCount))
			.findAny()
			.orElse(FAILED);
	}

	private boolean hasMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getWinningPrice() {
		return winningPrice;
	}
}
