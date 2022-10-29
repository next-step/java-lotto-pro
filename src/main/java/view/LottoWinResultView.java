package view;

import lotto.LottoMatchCounts;
import lotto.LottoTicket;
import lotto.LottoTickets;
import lotto.LottoWinResult;
import lotto.ProfitMargin;
import money.Money;

public class LottoWinResultView {

	private static final String WIN_RESULT_OUTPUT = "당첨 통계 \n--------- \n";
	private static final String PROFIT_RESULT_OUTPUT = "총 수익률은 %s입니다.";
	private static final String LOSS_RESULT_OUTPUT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	private final Money lottoPrice;

	public LottoWinResultView(Money lottoPrice) {
		this.lottoPrice = lottoPrice;
	}

	public void getResult(LottoTickets purchaseLottoTickets, LottoTicket lastWeekWinLottoTicket) {
		LottoMatchCounts lottoMatchCounts = purchaseLottoTickets.match(lastWeekWinLottoTicket);

		System.out.println();
		System.out.println(WIN_RESULT_OUTPUT);
		for (LottoWinPrize winPrize : LottoWinPrize.values()) {
			getMatchCount(lottoMatchCounts, winPrize);
		}
		getProfitMargin(purchaseLottoTickets, lottoMatchCounts);
	}

	private void getMatchCount(LottoMatchCounts lottoMatchCounts, LottoWinPrize lottoWinPrize) {
		int matchCount = lottoMatchCounts.getMatchCount(lottoWinPrize.matchCount);
		System.out.printf("%s개 일치(%s원) - %s개", lottoWinPrize.matchCount, lottoWinPrize.prize, matchCount);
		System.out.println();
	}

	private void getProfitMargin(LottoTickets purchaseLottoTickets, LottoMatchCounts lottoMatchCounts) {
		System.out.println("");
		ProfitMargin profitMargin = LottoWinResult.computeProfitMargin(
			getPurchaseAmount(purchaseLottoTickets.getCount()), lottoMatchCounts);
		System.out.printf(PROFIT_RESULT_OUTPUT, profitMargin);

		printIfLoss(profitMargin);
	}

	private void printIfLoss(ProfitMargin profitMargin) {
		if (profitMargin.isLoss()) {
			System.out.println(LOSS_RESULT_OUTPUT);
		}
	}

	private Money getPurchaseAmount(int count) {
		return lottoPrice.multiply(count);
	}
}
