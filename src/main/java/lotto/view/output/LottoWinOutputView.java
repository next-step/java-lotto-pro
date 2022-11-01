package lotto.view.output;

import lotto.controller.dto.LottoWinResultResponse;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.domain.ProfitMargin;

public class LottoWinOutputView {
	private static final String WIN_RESULT_OUTPUT = "당첨 통계 \n--------- \n";
	private static final String PROFIT_RESULT_OUTPUT = "총 수익률은 %s입니다.";
	private static final String LOSS_RESULT_OUTPUT = " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public LottoWinOutputView() {
	}

	public void printWinResult(LottoWinResultsResponse response) {
		printMatchCount(response);
		printProfitMargin(response);
	}

	private void printMatchCount(LottoWinResultsResponse lottoWinResultsResponse) {
		System.out.println();
		System.out.println(WIN_RESULT_OUTPUT);
		lottoWinResultsResponse.forEach(this::printMatchCount);
	}

	private void printMatchCount(LottoWinResultResponse lottoWinResultResponse) {
		System.out.printf("%s개 일치%s (%s원) - %s개",
			lottoWinResultResponse.getMatchCount(),
			getBonusBallDescription(lottoWinResultResponse),
			lottoWinResultResponse.getWinningMoney(),
			lottoWinResultResponse.getNumberOfMatch());
		System.out.println();
	}

	private String getBonusBallDescription(LottoWinResultResponse lottoWinResultResponse) {
		return lottoWinResultResponse.hasBonusBall() ? ", 보너스 볼 일치" : "";
	}

	private void printProfitMargin(LottoWinResultsResponse lottoWinResultsResponse) {
		System.out.println();

		ProfitMargin profitMargin = lottoWinResultsResponse.getProfitMargin();
		System.out.printf(PROFIT_RESULT_OUTPUT, profitMargin);

		printIfLoss(lottoWinResultsResponse.getProfitMargin());
	}

	private void printIfLoss(ProfitMargin profitMargin) {
		if (profitMargin.isLoss()) {
			System.out.println(LOSS_RESULT_OUTPUT);
		}
	}

}
