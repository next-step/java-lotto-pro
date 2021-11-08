package lotto.domain;

import java.util.Arrays;

import lotto.domain.exception.IllegalMatchCountException;

public enum Rank {
	LOSS(0, false, 0),
	FIFTH(3, false, 5_000),
	FOURTH(4, false,50_000),
	THIRD(5, false, 1_500_000),
	SECOND(5,true, 30_000_000),
	FIRST(6, false,2_000_000_000);

	private int matchCount;
	private boolean matchBonus;
	private int prizeMoney;

	Rank(final int matchCount, final boolean matchBonus, final int prizeMoney) {
		this.matchCount = matchCount;
		this.matchBonus = matchBonus;
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

		if (rank == Rank.THIRD && matchBonus) {
			return Rank.SECOND;
		}

		return rank;
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
