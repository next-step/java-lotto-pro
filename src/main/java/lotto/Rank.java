package lotto;

import java.util.Arrays;

public enum Rank {
	FIRST(6),
	SECOND(5),
	THIRD(4),
	FOURTH(3),
	MISS(0),
	;

	private final int count;

	Rank(final int count) {
		this.count = count;
	}

	public static Rank from(final int count) {
		return Arrays.stream(values())
			.filter(rank -> rank.count == count)
			.findAny()
			.orElse(MISS);
	}
}
