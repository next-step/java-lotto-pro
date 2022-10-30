package lotto.controller.dto;

import lotto.domain.LottoWinPrize;
import lotto.domain.LottoWinPrizes;
import money.Money;

public class LottoWinResultResponse {

	private final Integer matchCount;
	private final Integer numberOfMatch;
	private final boolean hasBonusBall;
	private final Money winningMoney;

	public LottoWinResultResponse(Integer matchCount, Integer numberOfMatch, boolean hasBonusBall, Money winningMoney) {
		this.matchCount = matchCount;
		this.numberOfMatch = numberOfMatch;
		this.hasBonusBall = hasBonusBall;
		this.winningMoney = winningMoney;
	}

	public static LottoWinResultResponse of(LottoWinPrize winPrize, LottoWinPrizes lottoWinPrizes) {
		return new LottoWinResultResponse(
			winPrize.matchCount,
			lottoWinPrizes.getWinPrizeCount(winPrize),
			winPrize.hasBonusBall,
			winPrize.prize);
	}

	public Integer getMatchCount() {
		return matchCount;
	}

	public Integer getNumberOfMatch() {
		return numberOfMatch;
	}

	public String getWinningMoney() {
		return winningMoney.toString();
	}

	public boolean hasBonusBall() {
		return hasBonusBall;
	}

}
