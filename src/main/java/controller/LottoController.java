package controller;

import java.util.Scanner;

import model.LastWeekWinningNumber;
import model.Lottos;
import model.Money;
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
		int purchaseVolume = Lottos.purchaseVolumeFrom(money.getValue());
		resultView.printPurchaseVolumeMessage(purchaseVolume);
		Lottos lottos = Lottos.purchase(purchaseVolume);
		resultView.printLottoNumbers(lottos);

		inputView.printLastWeekWinningNumberMessage();
		LastWeekWinningNumber lastWeekWinningNumber = inputForLastWeekWinningNumberUntilValid(sc.nextLine());

		resultView.printWinningStatisticsMessage(lottos.matchResult(lastWeekWinningNumber), money.getValue());
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
