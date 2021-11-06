package controller;

import model.LastWeekWinningNumber;
import model.Lottos;
import model.Money;
import model.PurchaseCount;
import view.InputView;
import view.ResultView;

public class LottoController {

	public void start() {
		Money money = InputView.printPurchaseAmountMessageAndInput();
		PurchaseCount purchaseCount = Lottos.purchaseCountFrom(money);
		ResultView.printPurchaseVolumeMessage(purchaseCount);
		Lottos lottos = Lottos.purchase(purchaseCount);
		ResultView.printLottoNumbers(lottos);

		LastWeekWinningNumber lastWeekWinningNumber = InputView.printLastWeekWinningNumberAndInput();

		ResultView.printWinningStatisticsMessage(lottos.matchResult(lastWeekWinningNumber), money);
	}

}
