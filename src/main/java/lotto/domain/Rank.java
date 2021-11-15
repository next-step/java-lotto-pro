package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
	FIRST(6, 200_000_000_000L),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	FAILED(0, 0);

	private final long matchCount;
	private final long prizeMoney;

	Rank(int matchCount, long prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank rank(long matchCount, boolean matchBonus) {

		if (matchBonus && SECOND.isMatchCount(matchCount)) {
			return SECOND;
		}

		return Stream.of(values())
			.filter(rank -> SECOND != rank && rank.isMatchCount(matchCount))
			.findFirst()
			.orElse(FAILED);
	}

	private boolean isMatchCount(long matchCount) {
		return this.matchCount == matchCount;
	}

	public long getPrizeMoney() {
		return this.prizeMoney;
	}

	public long getMatchCount() {
		return matchCount;
	}
}
