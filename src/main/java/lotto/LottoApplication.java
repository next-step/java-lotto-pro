package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.controller.dto.BoughtLottoResponse;
import lotto.controller.dto.LottoWinResultRequest;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.view.input.LottoBonusNumberInputView;
import lotto.view.input.LottoManualNumbersInputView;
import lotto.view.input.LottoMoneyInputView;
import lotto.view.input.LottoWinNumberInputView;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoWinOutputView;
import utils.ExceptionHandler;

public class LottoApplication {

	private static final LottoController lottoController = LottoFactory.createLottoController();

	private static final LottoMoneyInputView moneyInputView = LottoFactory.createMoneyInputView();
	private static final LottoManualNumbersInputView manualNumbersInputView = LottoFactory.createManualNumbersInputView();
	private static final LottoBuyOutputView buyOutputView = LottoFactory.createBuyOutputView();
	private static final LottoWinNumberInputView winNumberInputView = LottoFactory.createWinNumberInputView();
	private static final LottoBonusNumberInputView bonusNumberInputView = LottoFactory.createBonusNumberInputView();
	private static final LottoWinOutputView winOutputView = LottoFactory.createWinOutputView();

	public static void main(String[] args) {
		BoughtLottoResponse boughtLottoResponse = buyLotto();

		showBoughtLotto(boughtLottoResponse);

		LottoWinResultsResponse winResults = getWinningLotto(boughtLottoResponse);

		showWinLottoResult(winResults);
	}

	private static BoughtLottoResponse buyLotto() {
		return ExceptionHandler.callWithHandlingException(() -> {
			int moneyToBuyLotto = moneyInputView.getMoneyToBuyLotto();
			List<List<Integer>> manualLottoNumbers = manualNumbersInputView.getManualLottoNumbers();

			return lottoController.buyLottoTickets(moneyToBuyLotto, manualLottoNumbers);
		});
	}

	private static void showBoughtLotto(BoughtLottoResponse boughtLottoResponse) {
		buyOutputView.printBuyingResult(boughtLottoResponse);
	}

	private static LottoWinResultsResponse getWinningLotto(BoughtLottoResponse boughtLottoResponse) {
		return ExceptionHandler.callWithHandlingException(() -> {
			List<Integer> winLottoNumbersRequest = winNumberInputView.getWinLottoNumbers();
			int bonusNumber = bonusNumberInputView.getBonusNumber();

			return lottoController.getWinResults(LottoWinResultRequest.of(
				boughtLottoResponse.getAutoLottoNumbers(),
				boughtLottoResponse.getManualLottoNumbers(),
				winLottoNumbersRequest,
				bonusNumber
			));
		});
	}

	private static void showWinLottoResult(LottoWinResultsResponse winResults) {
		winOutputView.printWinResult(winResults);
	}

}
