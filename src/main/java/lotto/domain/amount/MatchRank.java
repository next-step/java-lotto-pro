package lotto.domain.amount;

import java.util.Arrays;

import lotto.domain.match.count.MatchCount;

public enum MatchRank {
	THREE_MATCH(MatchCount.from(3), Amount.from(5000L)),
	FOUR_MATCH(MatchCount.from(4), Amount.from(50000L)),
	FIVE_MATCH(MatchCount.from(5), Amount.from(1500000L)),
	SIX_MATCH(MatchCount.from(6), Amount.from(2000000000L));

	public static final int NO_WINNING_PRICE = 0;

	private final MatchCount matchCount;
	private final Amount winningPrice;

	MatchRank(MatchCount matchCount, Amount winningPrice) {
		this.matchCount = matchCount;
		this.winningPrice = winningPrice;
	}

	public static Amount getWinningPrice(MatchCount matchCount) {
		return Arrays.stream(MatchRank.values())
			.filter(matchRank -> matchRank.hasMatchCount(matchCount))
			.findAny()
			.map(matchRank -> matchRank.winningPrice)
			.orElse(Amount.from(NO_WINNING_PRICE));
	}

	private boolean hasMatchCount(MatchCount matchCount) {
		return this.matchCount.equals(matchCount);
	}

	public int getMatchCount() {
		return matchCount.getInt();
	}
}
