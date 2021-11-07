package view;

import static view.InputMessage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BonusBall;
import model.Count;
import model.LastWeekWinningNumber;
import model.Lotto;
import model.Lottos;
import model.Money;
import model.PurchaseCount;

public class InputView {

	private static final Scanner sc = new Scanner(System.in);

	public static Money printPurchaseAmountMessageAndInput() {
		printPurchaseAmountMessage();
		return inputForPurchaseAmountUntilValid(sc.nextLine());
	}

	public static PurchaseCount printManualPurchaseCountMessageAndInput(Money money) {
		nextLine();
		printManualPurchaseCountMessage();
		return inputForManualCountUntilValid(sc.nextLine(), money);
	}

	public static Lottos printManualLottoNumberMessageAndInput(PurchaseCount purchaseCount) {
		nextLine();
		printManualLottoNumberMessage();

		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < purchaseCount.getValue(); i++) {
			Lotto lotto = inputForManualLottoNumberUntilValid(sc.nextLine());
			lottoList.add(lotto);
		}

		return Lottos.of(lottoList);
	}


	public static LastWeekWinningNumber printLastWeekWinningNumberAndInput() {
		printLastWeekWinningNumberMessage();
		return inputForLastWeekWinningNumberUntilValid(sc.nextLine());
	}

	public static BonusBall printBonusBallAndInput(LastWeekWinningNumber lastWeekWinningNumber) {
		printBonusBallMessage();
		return inputForBonusBallUntilValid(sc.nextLine(), lastWeekWinningNumber);
	}

	private static void printManualPurchaseCountMessage() {
		System.out.println(MANUAL_PURCHASE_COUNT_MESSAGE);
	}

	private static void printManualLottoNumberMessage() {
		System.out.println(MANUAL_LOTTO_NUMBER_MESSAGE);
	}

	private static void printPurchaseAmountMessage() {
		System.out.println(PURCHASE_AMOUNT_MESSAGE);
	}

	private static void printLastWeekWinningNumberMessage() {
		nextLine();
		System.out.println(LAST_WEEK_WINNING_NUMBER_MESSAGE);
	}

	private static void printBonusBallMessage() {
		System.out.println(BONUS_BALL_MESSAGE);
	}

	public static void printErrorPurchaseAmountInvalidation() {
		System.out.println(ERROR_PURCHASE_AMOUNT_MESSAGE);
	}

	public static void printErrorLottoNumberInvalidation() {
		System.out.println(ERROR_LOTTO_NUMBER_MESSAGE);
	}

	private static Money inputForPurchaseAmountUntilValid(String money) {
		while (!Money.validate(money)) {
			InputView.printErrorPurchaseAmountInvalidation();
			money = sc.nextLine();
		}

		return Money.of(money);
	}

	private static LastWeekWinningNumber inputForLastWeekWinningNumberUntilValid(String lastWeekNumber) {
		while (!LastWeekWinningNumber.validate(lastWeekNumber)) {
			InputView.printErrorLottoNumberInvalidation();
			lastWeekNumber = sc.nextLine();
		}

		return LastWeekWinningNumber.of(lastWeekNumber);
	}

	private static BonusBall inputForBonusBallUntilValid(String bonusBall,
		LastWeekWinningNumber lastWeekWinningNumber) {
		while (!(BonusBall.validate(bonusBall) && lastWeekWinningNumber.isNotContain(bonusBall))) {
			InputView.printErrorBonusBallInvalidation();
			bonusBall = sc.nextLine();
		}

		return BonusBall.from(bonusBall);
	}

	private static PurchaseCount inputForManualCountUntilValid(String manualCount, Money money) {
		while (!(PurchaseCount.validate(manualCount)
			&& money.isPurchaseable(Money.of(Lotto.COST, Count.from(manualCount))))) {

			InputView.printErrorManualCountInvalidation();
			manualCount = sc.nextLine();
		}

		return PurchaseCount.from(manualCount);
	}

	private static Lotto inputForManualLottoNumberUntilValid(String numbers) {
		while(!Lotto.validate(numbers)) {
			InputView.printErrorLottoNumberInvalidation();
			numbers = sc.nextLine();
		}

		return Lotto.of(numbers);
	}

	private static void printErrorBonusBallInvalidation() {
		System.out.println(ERROR_BONUS_BALL_MESSAGE);
	}

	private static void printErrorManualCountInvalidation() {
		System.out.println(ERROR_MANUAL_COUNT_MESSAGE);
	}

	private static void nextLine() {
		System.out.println();
	}
}
