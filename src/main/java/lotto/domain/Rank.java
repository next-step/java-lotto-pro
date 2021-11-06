package lotto.domain;

import java.util.Objects;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private final int matchCnt;
	private final int prize;

	private Rank(int matchCnt, int prize) {
		this.matchCnt = matchCnt;
		this.prize = prize;
	}

	public static Rank getMatchRank(LottoNumber winningNumber, LottoNumber number) {
		int matchCnt = winningNumber.getMatchCount(number);
		boolean isMatchBonus = LottoNumber.isContainBonusNumber(winningNumber, number);
		return valueOf(matchCnt, isMatchBonus);
	}

	public static Rank valueOf(int matchCnt, boolean isMatchBonus) {
		Rank[] ranks = values();
		for (Rank rank : ranks) {
			Rank matchedRank = getMatchedRank(rank, matchCnt, isMatchBonus);
			if (Objects.nonNull(matchedRank)) {
				return matchedRank;
			}
		}
		return MISS;
	}

	private static Rank getMatchedRank(Rank rank, int matchCnt, boolean isMatchBonus) {
		if (matchCnt == SECOND.getMatchCnt() && isMatchBonus) {
			return SECOND;
		}
		if (matchCnt == THIRD.getMatchCnt() && !isMatchBonus) {
			return THIRD;
		}
		if (rank.matchCnt == matchCnt) {
			return rank;
		}
		return null;
	}

	public int getMatchCnt() {
		return this.matchCnt;
	}

	public int getPrize() {
		return this.prize;
	}

}
