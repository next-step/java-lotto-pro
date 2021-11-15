package model;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
	FIRST(2_000_000_000, 6, false),
	SECOND(30_000_000, 5, true),
	THIRD(1_500_000, 5, false),
	FOURTH(50_000, 4, false),
	FIFTH(5_000, 3, false),
	NONE(0, 0, false);

	private final int reward;
	private final int matchingCount;
	private final boolean isMatchBonusNumber;

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
