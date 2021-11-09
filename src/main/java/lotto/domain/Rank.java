package lotto.domain;

import java.util.Arrays;

import lotto.domain.exception.IllegalMatchCountException;

public enum Rank {
	LOSS(0, 0),
	FIFTH(3, 5_000),
	FOURTH(4,50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6,2_000_000_000);

	private final int matchCount;
	private final int prizeMoney;

	Rank(final int matchCount, final int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank from(final int matchCount) {
		return from(matchCount, false);
	}

	public static Rank from(final int matchCount, final boolean matchBonus) {
		if (matchCount < FIFTH.matchCount) {
			return LOSS;
		}

		Rank rank = Arrays.stream(values())
			.filter(r -> r.isCountMatch(matchCount))
			.findFirst()
			.orElseThrow(IllegalMatchCountException::new);

		if (isSecondRank(rank, matchBonus)) {
			return Rank.SECOND;
		}

		return rank;
	}

	private static boolean isSecondRank(Rank rank, boolean matchBonus) {
		return rank == Rank.THIRD && matchBonus;
	}

	public int matchCount() {
		return matchCount;
	}

	public int prizeMoney() {
		return prizeMoney;
	}

	private boolean isCountMatch(int matchCount) {
		return this.matchCount == matchCount;
	}
}
