package controller;

import java.util.Scanner;

import model.LastWeekWinningNumber;
import model.Lottos;
import model.Money;
import model.PurchaseCount;
import view.InputView;
import view.ResultView;

public class LottoController {
	private static Scanner sc = new Scanner(System.in);

	public void start() {
		InputView.printPurchaseAmountMessage();
		Money money = inputForPurchaseAmountUntilValid(sc.nextLine());
		PurchaseCount purchaseCount = Lottos.purchaseCountFrom(money);
		ResultView.printPurchaseVolumeMessage(purchaseCount);
		Lottos lottos = Lottos.purchase(purchaseCount);
		ResultView.printLottoNumbers(lottos);

		InputView.printLastWeekWinningNumberMessage();
		LastWeekWinningNumber lastWeekWinningNumber = inputForLastWeekWinningNumberUntilValid(sc.nextLine());

		ResultView.printWinningStatisticsMessage(lottos.matchResult(lastWeekWinningNumber), money);
	}

	public Money inputForPurchaseAmountUntilValid(String money) {
		while (!Money.validate(money)) {
			InputView.printErrorPurchaseAmountInvalidation();
			money = sc.nextLine();
		}

		return Money.of(money);
	}

	private LastWeekWinningNumber inputForLastWeekWinningNumberUntilValid(String lastWeekNumber) {
		while (!LastWeekWinningNumber.validate(lastWeekNumber)) {
			InputView.printErrorLastWeekWinningNumberInvalidation();
			lastWeekNumber = sc.nextLine();
		}

		return LastWeekWinningNumber.of(lastWeekNumber);
	}
}
