package lotto;

import lotto.controller.LottoApplicationController;
import lotto.controller.Repeater;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {


	public static void main(String[] args) {
		Repeater.init();
		LottoApplicationController lottoApplicationController = new LottoApplicationController();

		Money purchaseAmount = null;
		while (Repeater.isContinue()) {
			purchaseAmount = InputView.enterPurchaseAmount();
			Repeater.set(purchaseAmount);
		}

		lottoApplicationController.purchaseLotto(purchaseAmount);

		OutputView.printPurchaseQuantity(purchaseAmount.getPurchaseQuantity(LottoShop.LOTTO_PRICE));
		OutputView.printPurchasedLottoNumbers(lottoApplicationController.getLottos());
		OutputView.newLine();

		String winningNumbers = "";
		Repeater.init();
		while (Repeater.isContinue()) {
			winningNumbers = InputView.enterWinningNumbers();
			Repeater.set(winningNumbers);
		}

		Money bonusBallNumber = null;
		Repeater.init();
		while (Repeater.isContinue()) {
			// bonusBallNumber = InputView.enterBonusBallNumber(winningNumbers);
			Repeater.set(bonusBallNumber);
		}
		OutputView.newLine();

		OutputView.printLottoStatisticsHeader();
		// OutputView.printLottoStatisticsBody(lottoApplicationController.recorde(winningNumbers, bonusBallNumber));
	}
}
