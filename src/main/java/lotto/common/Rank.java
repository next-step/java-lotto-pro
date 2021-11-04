package lotto.common;

import java.util.Arrays;
import java.util.Collections;

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

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		if (countOfMatch == 5 && matchBonus) {
			return Rank.SECOND;
		}

		Rank[] ranks = values();
		return Arrays.stream(ranks)
			.filter(rank -> rank.countOfMatch == countOfMatch)
			.findFirst().orElse(Rank.MISS);
	}

	public static Rank[] valuesForResult() {
		Rank[] ranks = values();
		return Arrays.stream(ranks).filter(rank -> rank != MISS)
			.sorted(Collections.reverseOrder()).toArray(Rank[]::new);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.countOfMatch);
		sb.append(Messages.MATCHED.getValues());
		if (this == SECOND) {
			sb.append(", ");
			sb.append(Messages.BONUS_BALL_MATCHED.getValues());
		}
		sb.append(" (");
		sb.append(this.getWinningMoney());
		sb.append(Messages.WON.getValues());
		sb.append(") - ");
		return sb.toString();
	}
}
