package model;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
	FIRST(2000000000, 6),
	THIRD(1500000, 5),
	FOURTH(50000, 4),
	FIFTH(5000, 3),
	NONE(0, 0)
	;

	private final int reward;
	private final int matchingCount;

	Rank(int reward, int matchingCount) {
		this.reward = reward;
		this.matchingCount = matchingCount;
	}

	public int getReward() {
		return reward;
	}

	public static Rank getByMatchingCount(int matchingCount) {
		Optional<Rank> optionalRank = Arrays.stream(values())
			.filter(rank -> rank.matchingCount == matchingCount)
			.findFirst();

		return optionalRank.orElse(Rank.NONE);
	}
}
