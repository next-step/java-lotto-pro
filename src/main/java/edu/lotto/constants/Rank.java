package edu.lotto.constants;

import edu.lotto.utils.MessageUtil;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Lotto 결과(순위) Enum
 * @since 2021.11.07
 * @author Inmook,Jeong
 */
public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private int rankNumber;
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
		Rank[] ranks = values();
		// 보너스볼을 포함하여 번호가 6개 일치하는 경우 2등
		if(SECOND.countOfMatch == countOfMatch && matchBonus)
			return SECOND;
		if(THIRD.countOfMatch == countOfMatch && !matchBonus)
			return THIRD;
		// 보너스 볼을 제외하고 번호가 일치하는 수에 따라 등수 계산
		if(Arrays.stream(ranks).filter(rank -> rank.countOfMatch == countOfMatch).count() != 0)
			return Arrays.stream(ranks).filter(rank -> rank.countOfMatch == countOfMatch).findFirst().get();
		return MISS;
	}
}
