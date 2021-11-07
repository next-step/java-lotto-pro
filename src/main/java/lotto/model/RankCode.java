package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum RankCode {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FORTH(3, 5_000),
	NOTHING(0, 0);

	private int containsCount;
	private int money;

	RankCode(int containsCount, int money) {
		this.containsCount = containsCount;
		this.money = money;
	}

	public static RankCode getRankCode(int containsCount) {
		return Arrays.stream(RankCode.values())
			.filter(rankCode -> rankCode.containsCount == containsCount)
			.findAny()
			.orElse(NOTHING);
	}

	public static int getRankMoney(RankCode rankCode, int count) {
		return rankCode.money * count;
	}

	public static Map<RankCode, Integer> generateRankCodeMap() {
		Map<RankCode, Integer> rankCodeMap = new HashMap<>();
		for (RankCode rankCode : RankCode.values()) {
			rankCodeMap.put(rankCode, NOTHING.containsCount);
		}
		return rankCodeMap;
	}

	public static int getMoney(RankCode rankCode) {
		return RankCode.valueOf(rankCode.name()).money;
	}

	public static int containsCount(RankCode rankCode) {
		return RankCode.valueOf(rankCode.name()).containsCount;
	}
}
