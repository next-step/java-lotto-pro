package com.example.lotto;

import java.util.Arrays;

public enum LottoRank {
	FIRST(1, 6, 2_000_000_000),
	SECOND(2, 5, 30_000_000),
	THIRD(3, 5, 1_500_000),
	FOURTH(4, 4, 50_000),
	FIFTH(5, 3, 5_000),
	MISS(6, 0, 0);

	private final int value;
	private final int countOfMatch;
	private final int winningMoney;

	LottoRank(int value, int countOfMatch, int winningMoney) {
		this.value = value;
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
		if (countOfMatch == SECOND.countOfMatch && matchBonus) {
			return SECOND;
		}

		return Arrays.stream(values())
			.filter(lottoRank -> !lottoRank.isSecond())
			.filter(lottoRank -> lottoRank.countOfMatch == countOfMatch)
			.findFirst()
			.orElse(MISS);
	}

	public int getValue() {
		return value;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	private boolean isSecond() {
		return this == SECOND;
	}

	public boolean isMiss() {
		return this == MISS;
	}
}
