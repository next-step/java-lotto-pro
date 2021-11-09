package lotto;

import lotto.controller.LottoApplicationController;
import lotto.controller.Repeater;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

	public static void main(String[] args) {
		Repeater.init();
		LottoApplicationController lottoApplicationController = new LottoApplicationController();

		int purchaseAmount = 0;
		while (Repeater.isContinue()) {
			purchaseAmount = InputView.enterPurchaseAmount();
			Repeater.set(purchaseAmount);
		}

		int purchaseQuantity = lottoApplicationController.getPurchaseQuantity(purchaseAmount);
		lottoApplicationController.purchaseLotto(purchaseQuantity);

		OutputView.printPurchaseQuantity(purchaseQuantity);
		OutputView.printPurchasedLottoNumbers(lottoApplicationController.getLottos());
		OutputView.newLine();

		String winningNumbers = "";
		Repeater.init();
		while (Repeater.isContinue()) {
			winningNumbers = InputView.enterWinningNumbers();
			Repeater.set(winningNumbers);
		}

		int bonusBallNumber = 0;
		Repeater.init();
		while (Repeater.isContinue()) {
			bonusBallNumber = InputView.enterBonusBallNumber(winningNumbers);
			Repeater.set(bonusBallNumber);
		}
		OutputView.newLine();

		OutputView.printLottoStatisticsHeader();
		OutputView.printLottoStatisticsBody(lottoApplicationController.recorde(winningNumbers, bonusBallNumber));
	}
}
