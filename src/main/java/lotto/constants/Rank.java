package lotto.constants;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2000000000), THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000), MISS(0, 0);

	private final int matchCount;
	private final int prize;

	Rank(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrize() {
		return prize;
	}

	public static Rank valueOf(int countOfMatch) {
		return Arrays.stream(values())
			.filter(rank -> rank.matchCount == countOfMatch)
			.findFirst()
			.orElse(MISS);
	}
}
