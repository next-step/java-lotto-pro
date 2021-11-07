package lotto.domain;

import java.util.Arrays;

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
		validateMatchCnt(matchCnt);
		return Arrays.stream(values())
			.filter(rank -> rank.isMatch(matchCnt, isMatchBonus))
			.findFirst()
			.orElse(MISS);
	}

	private static void validateMatchCnt(int matchCnt) {
		if (matchCnt > 6 || matchCnt < 0) {
			throw new IllegalArgumentException("일치하는 개숫는 0~6이어야 합니다.");
		}
	}

	private boolean isMatch(int matchCnt, boolean isMatchBonus) {
		if (this.matchCnt != matchCnt) {
			return false;
		}
		if (this.equals(Rank.SECOND)) {
			return isMatchBonus;
		}
		return true;
	}

	public int getMatchCnt() {
		return this.matchCnt;
	}

	public int getPrize() {
		return this.prize;
	}

}
