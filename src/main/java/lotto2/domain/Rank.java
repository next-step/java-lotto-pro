package lotto2.domain;

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

	Rank(int matchCnt, int prize) {
		this.matchCnt = matchCnt;
		this.prize = prize;
	}

	public static Rank valueOf(PositiveNumber matchCnt, boolean isMatchBonus) {
		validateMatchCnt(matchCnt);
		return Arrays.stream(values())
			.filter(rank -> rank.isMatch(matchCnt, isMatchBonus))
			.findFirst()
			.orElse(MISS);
	}

	private static void validateMatchCnt(PositiveNumber matchCnt) {
		if (matchCnt.toInt() > FIRST.matchCnt || matchCnt.toInt() < MISS.matchCnt) {
			throw new IllegalArgumentException(ErrorMessage.MATCH_CNT_OUT_OF_RANGE.value());
		}
	}

	private boolean isMatch(PositiveNumber matchCnt, boolean isMatchBonus) {
		if (this.matchCnt != matchCnt.toInt()) {
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
