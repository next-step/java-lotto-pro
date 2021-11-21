package model;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
	FIRST(2_000_000_000, 6),
	SECOND(30_000_000, 5, true),
	THIRD(1_500_000, 5),
	FOURTH(50_000, 4),
	FIFTH(5_000, 3),
	NONE(0, 0);

	private final int reward;
	private final int matchingCount;
	private final boolean isMatchBonusNumber;

	Rank(int reward, int matchingCount) {
		this(reward, matchingCount, false);
	}

	Rank(int reward, int matchingCount, boolean isMatchBonusNumber) {
		this.reward = reward;
		this.matchingCount = matchingCount;
		this.isMatchBonusNumber = isMatchBonusNumber;
	}

	public int getReward() {
		return reward;
	}

	public static Rank mapByMatchingCountAndBonusFlag(int matchingCount, boolean isMatchBonusNumber) {
		Optional<Rank> optionalRank = Arrays.stream(values())
			.filter(rank -> rank.matchingCount == matchingCount)
			.filter(rank -> mapMatchBonusNumber(rank, isMatchBonusNumber))
			.findFirst();

		return optionalRank.orElse(Rank.NONE);
	}

	private static boolean mapMatchBonusNumber(Rank rank, boolean isMatchBonusNumber) {
		return !rank.isMatchBonusNumber || isMatchBonusNumber;
	}
}
