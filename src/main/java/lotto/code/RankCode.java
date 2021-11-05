package lotto.code;

import java.util.Arrays;

public enum RankCode {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FORTH(3, 5000),
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
}
