package lotto.domain;

import java.util.Arrays;

public enum Rank {

	MISS(0, 0),
	FIFTH(3, 5000),
	FOURTH(4, 50000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),
	FIRST(6, 2000000000);

	private final int countOfMatch;
	private final Money winningAmount;

	Rank(int countOfMatch, int winningAmount) {
		this.countOfMatch = countOfMatch;
		this.winningAmount = new Money(winningAmount);
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningAmount() {
		return winningAmount.value();
	}

	public static Rank checkRank(long countOfMatch, boolean bonusNumberMatch) {
		if (countOfMatch < Rank.FIFTH.getCountOfMatch()) {
			return Rank.MISS;
		}
		if (countOfMatch == Rank.SECOND.getCountOfMatch()) {
			return secondOrThirdRank(bonusNumberMatch);
		}
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.getCountOfMatch() == countOfMatch)
			.findFirst()
			.get();
	}

	private static Rank secondOrThirdRank(boolean bonusBallMatch) {
		if (bonusBallMatch) {
			return Rank.SECOND;
		}
		return Rank.THIRD;
	}
}
