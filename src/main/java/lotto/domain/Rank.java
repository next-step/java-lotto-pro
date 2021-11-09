package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
	FIRST(6, "200_000_000_000"),
	SECOND(5, "30_000_000"),
	THIRD(5, "1_500_000"),
	FOURTH(4, "50_000"),
	FIFTH(3, "5_000"),
	FAILED(0, "0");

	public static final String REPLACEMENT_EMPTY = "";
	public static final String REPLACEMENT_TARGET = "_";

	private final long matchCount;
	private final String prizeMoney;

	Rank(int matchCount, String prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank rank(long matchCount, boolean matchBonus) {
		if (isFailed(matchCount)) {
			return FAILED;
		}

		if(SECOND.isMatchCount(matchCount)){
			return rankBonus(matchBonus);
		}

		return Stream.of(values())
			.filter(rank -> rank.isMatchCount(matchCount))
			.findFirst()
			.orElse(FAILED);
	}

	private static Rank rankBonus(boolean matchBonus) {
		if(matchBonus){
			return SECOND;
		}
		return THIRD;
	}

	private static boolean isFailed(long matchCount) {
		return FIFTH.matchCount > matchCount;
	}

	private boolean isMatchCount(long matchCount) {
		return this.matchCount == matchCount;
	}

	public long getPrizeMoney() {
		return Long.parseLong(this.prizeMoney.replace(REPLACEMENT_TARGET, REPLACEMENT_EMPTY));
	}

	public long getMatchCount() {
		return matchCount;
	}
}
