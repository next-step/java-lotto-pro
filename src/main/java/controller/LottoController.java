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

	private final InputView inputView;
	private final ResultView resultView;

	public LottoController(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void start() {
		inputView.printPurchaseAmountMessage();
		Money money = inputForPurchaseAmountUntilValid(sc.nextLine());
		PurchaseCount purchaseCount = Lottos.purchaseCountFrom(money);
		resultView.printPurchaseVolumeMessage(purchaseCount);
		Lottos lottos = Lottos.purchase(purchaseCount);
		resultView.printLottoNumbers(lottos);

		inputView.printLastWeekWinningNumberMessage();
		LastWeekWinningNumber lastWeekWinningNumber = inputForLastWeekWinningNumberUntilValid(sc.nextLine());

		resultView.printWinningStatisticsMessage(lottos.matchResult(lastWeekWinningNumber), money);
	}

	public Money inputForPurchaseAmountUntilValid(String money) {
		while (!Money.validate(money)) {
			inputView.printErrorPurchaseAmountInvalidation();
			money = sc.nextLine();
		}

		return Money.of(money);
	}

	private LastWeekWinningNumber inputForLastWeekWinningNumberUntilValid(String lastWeekNumber) {
		while (!LastWeekWinningNumber.validate(lastWeekNumber)) {
			inputView.printErrorLastWeekWinningNumberInvalidation();
			lastWeekNumber = sc.nextLine();
		}

		return LastWeekWinningNumber.of(lastWeekNumber);
	}
}
