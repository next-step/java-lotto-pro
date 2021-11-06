package view;

import static view.InputMessage.*;

import java.util.Scanner;

import model.LastWeekWinningNumber;
import model.Money;

public class InputView {

	private static final Scanner sc = new Scanner(System.in);

	public static Money printPurchaseAmountMessageAndInput() {
		printPurchaseAmountMessage();
		return inputForPurchaseAmountUntilValid(sc.nextLine());
	}

	public static LastWeekWinningNumber printLastWeekWinningNumberAndInput() {
		printLastWeekWinningNumberMessage();
		return inputForLastWeekWinningNumberUntilValid(sc.nextLine());
	}

	private static void printPurchaseAmountMessage() {
		System.out.println(PURCHASE_AMOUNT_MESSAGE);
	}

	private static void printLastWeekWinningNumberMessage() {
		nextLine();
		System.out.println(LASE_WEEK_WINNING_NUMBER_MESSAGE);
	}

	public static void printErrorPurchaseAmountInvalidation() {
		System.out.println(ERROR_PURCHASE_AMOUNT_MESSAGE);
	}

	public static void printErrorLastWeekWinningNumberInvalidation() {
		System.out.println(ERROR_LAST_WEEK_WINNING_NUMBER_MESSAGE);
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
			InputView.printErrorLastWeekWinningNumberInvalidation();
			lastWeekNumber = sc.nextLine();
		}

		return LastWeekWinningNumber.of(lastWeekNumber);
	}

	private static void nextLine() {
		System.out.println();
	}
}
