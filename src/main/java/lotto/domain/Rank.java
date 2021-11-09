package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
	FIRST(6, "200_000_000_000"),
	SECOND(5, "1_500_000"),
	THIRD(4, "50_000"),
	FOURTH(3, "5_000"),
	FAILED(0, "0");

	public static final String REPLACEMENT_EMPTY = "";
	public static final String REPLACEMENT_TARGET = "_";

	private final long matchCount;
	private final String prizeMoney;

	Rank(int matchCount, String prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank rank(long matchCount) {
		return Stream.of(values())
			.filter(rank -> rank.matchCount == matchCount)
			.findFirst()
			.orElse(FAILED);
	}

	public long getPrizeMoney() {
		return Long.parseLong(this.prizeMoney.replace(REPLACEMENT_TARGET, REPLACEMENT_EMPTY));
	}

	public long getMatchCount() {
		return matchCount;
	}
}
