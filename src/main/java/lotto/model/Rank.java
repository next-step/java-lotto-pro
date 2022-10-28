package lotto.model;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000L),
	SECOND(5, 1_500_000L),
	THIRD(4, 50_000L),
	FOURTH(3, 5_000L),
	MISS(0, 0L);

	private final int count;
	private final long prize;

	Rank(final int count, final long prize) {
		this.count = count;
		this.prize = prize;
	}

	public static Rank from(final int count) {
		return Arrays.stream(values())
			.filter(rank -> rank.count == count)
			.findAny()
			.orElse(MISS);
	}

	public long prize(){
		return prize;
	}
}
