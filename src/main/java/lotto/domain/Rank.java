package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	LOSE(0, 0);

	private final long prize;
	private final int matchCount;

	Rank(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public static Rank of(int matchCount) {
		return Arrays.stream(values())
			.filter(r -> r.matchCount == matchCount)
			.findAny()
			.orElse(LOSE);
	}

	public long getPrize() {
		return this.prize;
	}

	public int getMatchCount() {
		return this.matchCount;
	}
}
