package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000, false),
	SECOND(5, 30_000_000, true),
	THIRD(5, 1_500_000, false),
	FOURTH(4, 50_000, false),
	FIFTH(3, 5_000, false),
	LOSE(0, 0, false);

	private final long prize;
	private final int matchCount;
	private final boolean matchingBonus;

	Rank(int matchCount, int prize, boolean matchingBonus) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.matchingBonus = matchingBonus;
	}

	public static Rank of(int matchCount, boolean matchingBonus) {
		return Arrays.stream(values())
			.filter(r -> r.matchCount == matchCount)
			.filter(r -> r.matchingBonus == matchingBonus)
			.findAny()
			.orElse(LOSE);
	}

	public long getPrize() {
		return this.prize;
	}

	public int getMatchCount() {
		return this.matchCount;
	}

	public boolean matchingBonus() {
		return this.matchingBonus;
	}
}
