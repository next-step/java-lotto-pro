package lotto.model;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);


	private int countOfMatch;
	private int winningMoney;

	private Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	/**
	 * 해당하는 로또 결과의 상금 반환
	 * @return 로또 결과 상금
	 */
	public int getWinningMoney() {
		return winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		if (countOfMatch == 2) {
			return matchBonus ? SECOND : THIRD;
		}
		return Arrays.stream(values())
			.filter(rank -> rank.getCountOfMatch() == countOfMatch)
			.findFirst()
			.orElse(MISS);
	}
}
