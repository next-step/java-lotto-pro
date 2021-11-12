package lotto.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum LottoRank {
	FIRST(6, 0, Money.from(2_000_000_000)),
	SECOND(5, 1, Money.from(30_000_000)),
	THIRD(5, 0, Money.from(1_500_000)),
	FORTH(4, 0, Money.from(50_000)),
	FIFTH(3, 0, Money.from(5_000)),
	NOTHING(0, 0, Money.from(0));

	private final int containsCount;
	private final int bonusCount;
	private final Money money;

	LottoRank(int containsCount, int bonusCount, Money money) {
		this.containsCount = containsCount;
		this.bonusCount = bonusCount;
		this.money = money;
	}

	public static LottoRank getRankCode(int containsCount, int bonusCount) {
		if (validSecondRank(containsCount)) {
			return getSecondRankCode(containsCount, bonusCount);
		}

		return Arrays.stream(LottoRank.values())
			.filter(rankCode -> rankCode.containsCount == containsCount)
			.findAny()
			.orElse(NOTHING);
	}

	public static LottoRank getSecondRankCode(int containsCount, int bonusCount) {
		return Arrays.stream(LottoRank.values())
			.filter(rankCode -> rankCode.containsCount == containsCount && bonusCount == SECOND.bonusCount)
			.findAny()
			.orElse(THIRD);
	}

	public static boolean validSecondRank(int containsCount) {
		return containsCount == LottoRank.SECOND.containsCount;
	}

	public static Map<LottoRank, Integer> generateRankCodeMap() {
		Map<LottoRank, Integer> rankCodeMap = new EnumMap<>(LottoRank.class);
		for (LottoRank rankCode : LottoRank.values()) {
			rankCodeMap.put(rankCode, NOTHING.containsCount);
		}
		return rankCodeMap;
	}

	public static Money getRankMoney(LottoRank lottoRank, int count) {
		return lottoRank.money.calculateRankMoney(new BigDecimal(count));
	}

	public static int getMoney(LottoRank lottoRank) {
		return LottoRank.valueOf(lottoRank.name()).money.getMoney();
	}

	public static int containsCount(LottoRank lottoRank) {
		return LottoRank.valueOf(lottoRank.name()).containsCount;
	}
}
