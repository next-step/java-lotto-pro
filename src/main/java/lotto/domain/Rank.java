package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
	FIRST(6, 2_000_000_000, false),
	SECOND(5, 3_000_000, true),
	THIRD(5, 1_500_000, false),
	FOURTH(4, 50_000, false),
	FIFTH(3, 5_000, false),
	NONE(0, 0, false);

	private final int matchCount;
	private final int prizeMoney;
	private final boolean matchBonus;

	Rank(int matchCount, int prizeMoney, boolean matchBonus) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
		this.matchBonus = matchBonus;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public static Rank matchPrize(int matchCount) {
		return matchPrize(matchCount, false);
	}
	public static Rank matchPrize(int matchCount, boolean matchBonus) {
		return Stream.of(values())
			.filter(rank -> rank.matchCount == matchCount)
			.filter(rank -> rank.matchBonus == matchBonus)
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
