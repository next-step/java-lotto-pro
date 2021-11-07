package controller;

import model.BonusBall;
import model.LastWeekWinningNumber;
import model.Lottos;
import model.Money;
import model.Purchase;
import model.PurchaseCount;
import view.InputView;
import view.ResultView;

public class LottoController {

	public void start() {
		Money money = InputView.printPurchaseAmountMessageAndInput();
		PurchaseCount manualPurchaseCount = InputView.printManualPurchaseCountMessageAndInput(money);
		Lottos manualLottos = InputView.printManualLottoNumberMessageAndInput(manualPurchaseCount);

		Purchase purchase = Purchase.of(money, manualPurchaseCount, manualLottos);
		ResultView.printPurchaseInfoMessage(purchase);
		Lottos lottos = Lottos.purchase(purchase);
		ResultView.printLottoNumbers(lottos);

		LastWeekWinningNumber lastWeekWinningNumber = InputView.printLastWeekWinningNumberAndInput();
		BonusBall bonusBall = InputView.printBonusBallAndInput(lastWeekWinningNumber);
		lastWeekWinningNumber.updateBonusBall(bonusBall);

		ResultView.printWinningStatisticsMessage(lottos.matchResult(lastWeekWinningNumber), money);
	}

}
