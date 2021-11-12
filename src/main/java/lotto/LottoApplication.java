package lotto;

import lotto.console.Repeater;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.console.InputView;
import lotto.console.OutputView;
import lotto.domain.WinningLotto;

public class LottoApplication {

	public static void main(String[] args) {
		Repeater.init();
		Money purchaseAmount = null;
		while (Repeater.isContinue()) {
			purchaseAmount = InputView.enterPurchaseAmount();
			Repeater.set(purchaseAmount);
		}
		OutputView.newLine();

		Repeater.init();
		Money manualPurchaseAmount = null;
		while (Repeater.isContinue()) {
			manualPurchaseAmount = InputView.enterManualLottoPurchaseQuantity(purchaseAmount);
			Repeater.set(manualPurchaseAmount);
		}
		OutputView.newLine();

		Repeater.init();
		Lottos manualLotts = null;
		while (Repeater.isContinue()) {
			manualLotts = InputView.enterManualLottoNumbers(manualPurchaseAmount);
			Repeater.set(manualPurchaseAmount);
		}
		OutputView.newLine();


		Lottos lottos = LottoShop.sell(purchaseAmount);

		OutputView.printPurchaseQuantity(purchaseAmount.getPurchaseQuantity(LottoShop.LOTTO_PRICE));
		OutputView.printPurchasedLottoNumbers(lottos.getLottos());
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
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBallNumber);

		LottoResult lottoResult = lottos.createLottoResult(winningLotto);
		OutputView.printLottoStatisticsHeader();
		OutputView.printLottoStatisticsBody(lottoResult);
	}
}
