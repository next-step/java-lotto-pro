package lotto.domain;

public class LottoStatics {

	public static LottoStaticsResult calculate(LottoTickets lottoTickets,
		WinningLotto winningLotto,
		Money purchaseMoney
	) {
		RankCounts rankCounts = lottoTickets.countRanks(winningLotto);
		double profit = rankCounts.calculateProfitRate(purchaseMoney);
		return LottoStaticsResult.of(rankCounts, profit);
	}

}
