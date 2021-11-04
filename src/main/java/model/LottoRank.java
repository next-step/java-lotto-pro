package model;

import java.util.Arrays;

public enum LottoRank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	NONE(0, 0);

	private final int matchCount;
	private final int prizeMoney;

	LottoRank(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	static LottoRank valueOfMatchCount(int matchCount) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.equalsMatchCount(matchCount))
			.findFirst()
			.orElse(NONE);
	}

	public int matchCount() {
		return matchCount;
	}

	public int prizeMoney() {
		return prizeMoney;
	}

	private boolean equalsMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}
}
