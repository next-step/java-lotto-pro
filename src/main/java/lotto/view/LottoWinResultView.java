package lotto.view;

import java.util.List;

import lotto.controller.LottoController;
import lotto.controller.dto.BoughtLottoTicketsResponse;
import lotto.controller.dto.LottoWinResultResponse;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.domain.ProfitMargin;
import utils.ExceptionHandler;
import utils.InputHandler;

public class LottoWinResultView {
	private static final String INPUT_PROMPT_OUTPUT = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String WIN_RESULT_OUTPUT = "당첨 통계 \n--------- \n";
	private static final String BONUS_NUMBER_PROMPT = "보너스 볼을 입력해 주세요.";
	private static final String PROFIT_RESULT_OUTPUT = "총 수익률은 %s입니다.";
	private static final String LOSS_RESULT_OUTPUT = " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	private final LottoController lottoController;
	private final InputHandler inputHandler;

	public LottoWinResultView(LottoController lottoController, InputHandler inputHandler) {
		this.lottoController = lottoController;
		this.inputHandler = inputHandler;
	}

	public void printWinResult(BoughtLottoTicketsResponse boughtLottoTickets) {

		LottoWinResultsResponse lottoWinResultsResponse = getLottoWinResults(boughtLottoTickets);

		printMatchCount(lottoWinResultsResponse);
		printProfitMargin(lottoWinResultsResponse);
	}

	private LottoWinResultsResponse getLottoWinResults(BoughtLottoTicketsResponse boughtLottoTickets) {
		return ExceptionHandler.callWithHandlingException(() -> {
			List<Integer> winningLottoNumbers = inputWinningLottoNumber();

			return lottoController.getWinResults(
				boughtLottoTickets, winningLottoNumbers, inputBonusNumber());
		});
	}

	private List<Integer> inputWinningLottoNumber() {
		return inputHandler.inputPositiveIntegerList(INPUT_PROMPT_OUTPUT);
	}

	private int inputBonusNumber() {
		return inputHandler.inputPositiveInteger(BONUS_NUMBER_PROMPT);
	}

	private void printMatchCount(LottoWinResultsResponse lottoWinResultsResponse) {
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
