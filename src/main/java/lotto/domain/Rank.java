package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
	FIRST(6, 2_000_000_000, (matchCount, matchingBonus) -> matchCount == 6),
	SECOND(5, 30_000_000, (matchCount, matchingBonus) -> matchCount == 5 && matchingBonus),
	THIRD(5, 1_500_000, (matchCount, matchingBonus) -> matchCount == 5 && !matchingBonus),
	FOURTH(4, 50_000, (matchCount, matchingBonus) -> matchCount == 4),
	FIFTH(3, 5_000, (matchCount, matchingBonus) -> matchCount == 3),
	LOSE(0, 0, (matchCount, matchingBonus) -> matchCount < 3);

	private final long prize;
	private final int matchCount;
	private final BiPredicate<Integer, Boolean> matchCondition;

	Rank(int matchCount, int prize, BiPredicate<Integer, Boolean> matchCondition) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.matchCondition = matchCondition;
	}

	public static Rank of(int matchCount, boolean matchingBonus) {
		return Arrays.stream(values())
			.filter(rank -> rank.matchCondition.test(matchCount, matchingBonus))
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
