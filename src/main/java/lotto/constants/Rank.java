package lotto.constants;

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

	Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		if (matchBonus && countOfMatch == 5) {
			return SECOND;
		}

		/**
		 * 여기선 stream을 썼지만 for loop와 if로 구현하게 된다면 depth가 2가 될 것으로 보이는데 어떻게 해결할 수 있을까요??
		 */
		return Arrays.stream(values())
			.filter(rank -> rank != Rank.SECOND)
			.filter(rank -> rank.countOfMatch == countOfMatch)
			.findFirst()
			.orElse(MISS);
	}

	public Integer calculateWinningMoney(int count) {
		return winningMoney * count;
	}
}
