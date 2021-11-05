package lottogame;

import java.util.Arrays;
import java.util.Optional;

import lottogame.exception.UnexpectedMatchException;

public enum LottoMatchRank {
	SIX_POINT(6, 2_000_000_000),
	FIVE_POINT(5, 1_500_000),
	FOUR_POINT(4, 50_000),
	THREE_POINT(3, 5_000),
	TWO_POINT(2, 0),
	ONE_POINT(1, 0),
	ZERO_POINT(0, 0);


	private int countOfMatch;
	private int winningMoney;

	private LottoMatchRank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static LottoMatchRank valueOf(int countOfMatch) {
		LottoMatchRank[] ranks = LottoMatchRank.values();
		Optional<LottoMatchRank> foundRank =Arrays.stream(ranks).filter(rank-> rank.getCountOfMatch()==countOfMatch).findFirst();
		return foundRank.orElseThrow(()->new UnexpectedMatchException("당첨 비교 중 에상치 못한 오류가 발생하였습니다."));
	}
}
