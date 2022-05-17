package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	NONE(0, 0);

	private final int matchCount;
	private final int prizeMoney;

	Rank(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public static Rank matchPrize(int matchCount) {
		return Stream.of(values())
			.filter(rank -> rank.matchCount == matchCount)
			.findFirst()
			.orElse(NONE);
	}

	public boolean isFirst() {
		return this.equals(FIRST);
	}

	public boolean isSecond() {
		return this.equals(SECOND);
	}

	public boolean isThird() {
		return this.equals(THIRD);
	}

	public boolean isFourth() {
		return this.equals(FOURTH);
	}
}
