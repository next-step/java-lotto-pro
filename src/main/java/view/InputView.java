package view;

import static view.InputMessage.*;

public class InputView {

	public static void printPurchaseAmountMessage() {
		System.out.println(PURCHASE_AMOUNT_MESSAGE);
	}

	public static void printLastWeekWinningNumberMessage() {
		nextLine();
		System.out.println(LASE_WEEK_WINNING_NUMBER_MESSAGE);
	}

	public static void printErrorPurchaseAmountInvalidation() {
		System.out.println(ERROR_PURCHASE_AMOUNT_MESSAGE);
	}

	public static void printErrorLastWeekWinningNumberInvalidation() {
		System.out.println(ERROR_LAST_WEEK_WINNING_NUMBER_MESSAGE);
	}

	private static void nextLine() {
		System.out.println();
	}
}
