package lotto;

import lotto.controller.LottoApplicationController;
import lotto.domain.Repeater;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

	public static void main(String[] args) {
		Repeater.init();
		LottoApplicationController lottoApplicationController = new LottoApplicationController();

		while (Repeater.isContinue()) {
			String purchaseAmount = InputView.enterPurchaseAmount();
			String validateResult = lottoApplicationController.validatePurchaseAmount(purchaseAmount);
			OutputView.printMessage(validateResult);
			Repeater.set(validateResult);
		}

		OutputView.printPurchaseQuantity(lottoApplicationController.getPurchaseQuantity());
		lottoApplicationController.purchaseLotto();

		OutputView.printPurchasedLottoNumbers(lottoApplicationController.getLotts());
		OutputView.newLine();

		Repeater.init();
		while (Repeater.isContinue()) {
			String WinningNumbers = InputView.enterWinningNumbers();
			String validateResult = lottoApplicationController.validateWinningNumbers(WinningNumbers);
			OutputView.printMessage(validateResult);
			Repeater.set(validateResult);
			OutputView.newLine();
		}
		OutputView.printLottoStatisticsHeader();
		OutputView.printLottoStatisticsBody(lottoApplicationController.recorde());
	}
}
