package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FORTH(3, 5_000),
	NOTHING(0, 0);

	private int containsCount;
	private int money;

	LottoRank(int containsCount, int money) {
		this.containsCount = containsCount;
		this.money = money;
	}

	public static LottoRank getRankCode(int containsCount) {
		return Arrays.stream(LottoRank.values())
			.filter(rankCode -> rankCode.containsCount == containsCount)
			.findAny()
			.orElse(NOTHING);
	}

	public static int getRankMoney(LottoRank lottoRank, int count) {
		return lottoRank.money * count;
	}

	public static Map<LottoRank, Integer> generateRankCodeMap() {
		Map<LottoRank, Integer> rankCodeMap = new HashMap<>();
		for (LottoRank lottoRank : LottoRank.values()) {
			rankCodeMap.put(lottoRank, NOTHING.containsCount);
		}
		return rankCodeMap;
	}

	public static int getMoney(LottoRank lottoRank) {
		return LottoRank.valueOf(lottoRank.name()).money;
	}

	public static int containsCount(LottoRank lottoRank) {
		return LottoRank.valueOf(lottoRank.name()).containsCount;
	}
}
