package view;

import lotto.LottoMatchResult;
import lotto.LottoTicket;
import lotto.LottoTickets;

public class LottoWinResultView {

	private static final String WIN_RESULT_OUTPUT = "당첨 통계 \n--------- \n";

	public LottoWinResultView() {
	}

	public void getResult(LottoTickets purchaseLottoTickets, LottoTicket lastWeekWinLottoTicket) {
		LottoMatchResult lottoMatchResult = purchaseLottoTickets.match(lastWeekWinLottoTicket);

		System.out.println();
		System.out.println(WIN_RESULT_OUTPUT);
		for (LottoWinPrize winPrize : LottoWinPrize.values()) {
			getMatchCount(lottoMatchResult, winPrize);
		}
	}

	private void getMatchCount(LottoMatchResult lottoMatchResult, LottoWinPrize lottoWinPrize) {
		int matchCount = lottoMatchResult.getMatchCount(lottoWinPrize.MATCH_COUNT);
		System.out.printf("%s개 일치(%s원) - %s개", lottoWinPrize.MATCH_COUNT, lottoWinPrize.PRIZE, matchCount);
		System.out.println("");
	}
}
