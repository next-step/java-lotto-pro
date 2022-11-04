package lotto.domain.lotto;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum MatchRank {
	FAILED((matchCount, bonusMatch) -> matchCount < 3, 0, 0L),
	FIFTH((matchCount, bonusMatch) -> matchCount == 3, 3, 5_000L),
	FOURTH((matchCount, bonusMatch) -> matchCount == 4, 4, 50_000L),
	THIRD((matchCount, bonusMatch) -> matchCount == 5 && !bonusMatch, 5, 1_500_000L),
	SECOND((matchCount, bonusMatch) -> matchCount == 5 && bonusMatch, 5, 30_000_000L),
	FIRST((matchCount, bonusMatch) -> matchCount == 6, 6, 2_000_000_000L);

	private final BiFunction<Integer, Boolean, Boolean> rankRule;
	private final int matchCount;
	private final long winningPrice;

	MatchRank(BiFunction<Integer, Boolean, Boolean> rankRule, int matchCount, long winningPrice) {
		this.rankRule = rankRule;
		this.matchCount = matchCount;
		this.winningPrice = winningPrice;
	}

	public static MatchRank valueOf(int matchCount, boolean bonusMatch) {
		validateMatchCount(matchCount);
		return Arrays.stream(MatchRank.values())
			.filter(matchRank -> matchRank.rankRule.apply(matchCount, bonusMatch))
			.findAny()
			.orElse(FAILED);
	}

	private static void validateMatchCount(int matchCount) {
		if (matchCount < 0) {
			throw new IllegalArgumentException("일치 횟수는 0보다 작을수 없습니다.");
		}
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getWinningPrice() {
		return winningPrice;
	}
}
