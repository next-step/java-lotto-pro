package lotto.view;

import lotto.domain.LottoMatchCounts;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinResults;
import lotto.domain.ProfitMargin;
import money.Money;

public class LottoWinResultView {

	private static final String WIN_RESULT_OUTPUT = "당첨 통계 \n--------- \n";
	private static final String PROFIT_RESULT_OUTPUT = "총 수익률은 %s입니다.";
	private static final String LOSS_RESULT_OUTPUT = " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	private final Money lottoPrice;

	public LottoWinResultView(Money lottoPrice) {
		this.lottoPrice = lottoPrice;
	}

	public void printWinResult(LottoTickets purchaseLottoTickets, LottoTicket lastWeekWinLottoTicket) {
		LottoMatchCounts lottoMatchCounts = purchaseLottoTickets.match(lastWeekWinLottoTicket);

		System.out.println(WIN_RESULT_OUTPUT);

		LottoWinResults lottoWinResults = LottoWinResults.computeWinResult(lottoMatchCounts);

		printMatchCount(lottoWinResults);

		printProfitMargin(lottoWinResults);
	}

	private void printMatchCount(LottoWinResults lottoWinResults) {
		printMatchCount(LottoWinPrize.THREE_MATCHES, lottoWinResults.getWinPrizeCount(LottoWinPrize.THREE_MATCHES));
		printMatchCount(LottoWinPrize.FOUR_MATCHES, lottoWinResults.getWinPrizeCount(LottoWinPrize.FOUR_MATCHES));
		printMatchCount(LottoWinPrize.FIVE_MATCHES, lottoWinResults.getWinPrizeCount(LottoWinPrize.FIVE_MATCHES));
		printMatchCount(LottoWinPrize.SIX_MATCHES, lottoWinResults.getWinPrizeCount(LottoWinPrize.SIX_MATCHES));
	}

	private void printMatchCount(LottoWinPrize winPrize, int winPrizeCount) {
		System.out.printf("%s개 일치(%s원) - %s개", winPrize.matchCount, winPrize.prize, winPrizeCount);
		System.out.println();
	}

	private void printProfitMargin(LottoWinResults lottoWinResults) {
		System.out.println();

		ProfitMargin profitMargin = lottoWinResults.getProfitMargin(lottoPrice);
		System.out.printf(PROFIT_RESULT_OUTPUT, profitMargin);

		printIfLoss(profitMargin);
	}

	private void printIfLoss(ProfitMargin profitMargin) {
		if (profitMargin.isProfitDecimal()) {
			System.out.println(LOSS_RESULT_OUTPUT);
		}
	}

}
