package lotto.domain;

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

	public int countWinners(Lottos lottos, WinningLotto winningLotto) {
		int count = 0;
		for (Lotto lotto : lottos.getLottos()) {
			count += ifSameRankCount(lotto.countMatchedNumber(winningLotto),
				lotto.isMatch(winningLotto.getBonusBallNumber()));
		}
		return count;
	}

	private int ifSameRankCount(long countOfMatch, boolean bonusBallMatch) {
		if (this == getRank(countOfMatch, bonusBallMatch)) {
			return 1;
		}
		return 0;
	}

	private Rank getRank(long countOfMatch, boolean bonusBallMatch) {
		if (countOfMatch == Rank.SECOND.getCountOfMatch()) {
			return secondOrThirdRank(bonusBallMatch);
		}

		if (this.getCountOfMatch() == countOfMatch) {
			return this;
		}
		return Rank.MISS;
	}

	private Rank secondOrThirdRank(boolean bonusBallMatch) {
		if (bonusBallMatch) {
			return Rank.SECOND;
		}
		return Rank.THIRD;
	}
}
