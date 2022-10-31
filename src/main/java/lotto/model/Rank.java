package lotto.model;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000L),
	SECOND(5, 30_000_000L),
	THIRD(5, 1_500_000L),
	FOURTH(4, 50_000L),
	FIFTH(3, 5_000L),
	MISS(0, 0L);

	private final int count;
	private final long prize;

	Rank(final int count, final long prize) {
		this.count = count;
		this.prize = prize;
	}

	public static Rank match(final int count, final boolean matchBonus) {
		if (SECOND.count == count) {
			return rankByBonus(matchBonus);
		}

		return Arrays.stream(values())
			.filter(rank -> rank.count == count)
			.findAny()
			.orElse(MISS);
	}

	private static Rank rankByBonus(final boolean matchBonus) {
		if (matchBonus) {
			return SECOND;
		}
		return THIRD;
	}

	public long prize() {
		return prize;
	}

}
