package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinPrizes;
import lotto.domain.ProfitMargin;
import money.Money;
import utils.InputHandler;

public class LottoWinResultView {

	private static final String WIN_RESULT_OUTPUT = "당첨 통계 \n--------- \n";
	private static final String BONUS_NUMBER_PROMPT = "보너스 볼을 입력해 주세요.";
	private static final String PROFIT_RESULT_OUTPUT = "총 수익률은 %s입니다.";
	private static final String LOSS_RESULT_OUTPUT = " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	private final Money lottoPrice;

	public LottoWinResultView(Money lottoPrice) {
		this.lottoPrice = lottoPrice;
	}

	public void printWinResult(LottoTickets purchaseLottoTickets, LottoTicket lastWeekWinLottoTicket) {
		LottoNumber bonusNumber = inputBonusNumber();

		LottoWinPrizes lottoWinPrizes = purchaseLottoTickets.match(lastWeekWinLottoTicket, bonusNumber);

		printMatchCount(lottoWinPrizes);
		printProfitMargin(lottoWinPrizes);
	}

	private LottoNumber inputBonusNumber() {
		System.out.println(BONUS_NUMBER_PROMPT);
		return LottoNumber.of(InputHandler.inputInteger());
	}

	private void printMatchCount(LottoWinPrizes lottoWinResults) {
		System.out.println(WIN_RESULT_OUTPUT);
		printMatchCount(LottoWinPrize.FIFTH, lottoWinResults.getWinPrizeCount(LottoWinPrize.FIFTH));
		printMatchCount(LottoWinPrize.FOURTH, lottoWinResults.getWinPrizeCount(LottoWinPrize.FOURTH));
		printMatchCount(LottoWinPrize.THIRD, lottoWinResults.getWinPrizeCount(LottoWinPrize.THIRD));
		printMatchCount(LottoWinPrize.SECOND, lottoWinResults.getWinPrizeCount(LottoWinPrize.SECOND));
		printMatchCount(LottoWinPrize.FIRST, lottoWinResults.getWinPrizeCount(LottoWinPrize.FIRST));
	}

	private void printMatchCount(LottoWinPrize winPrize, int winPrizeCount) {
		System.out.printf("%s개 일치%s (%s원) - %s개", winPrize.matchCount, printIfBonusBall(winPrize), winPrize.prize,
			winPrizeCount);
		System.out.println();
	}

	private String printIfBonusBall(LottoWinPrize winPrize) {
		return winPrize == LottoWinPrize.SECOND ? ", 보너스 볼 일치" : "";
	}

	private void printProfitMargin(LottoWinPrizes lottoWinResults) {
		System.out.println();

		ProfitMargin profitMargin = lottoWinResults.getProfitMargin(lottoPrice);
		System.out.printf(PROFIT_RESULT_OUTPUT, profitMargin);

		printIfLoss(profitMargin);
	}

	private void printIfLoss(ProfitMargin profitMargin) {
		if (profitMargin.isLoss()) {
			System.out.println(LOSS_RESULT_OUTPUT);
		}
	}

}
