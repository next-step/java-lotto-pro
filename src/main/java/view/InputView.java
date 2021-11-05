package view;

import static view.InputMessage.*;

public class InputView {

	public void printPurchaseAmountMessage() {
		System.out.println(PURCHASE_AMOUNT_MESSAGE);
	}

	public void printLastWeekWinningNumberMessage() {
		nextLine();
		System.out.println(LASE_WEEK_WINNING_NUMBER_MESSAGE);
	}

	private void nextLine() {
		System.out.println();
	}

	public void printErrorPurchaseAmountInvalidation() {
		System.out.println(ERROR_PURCHASE_AMOUNT_MESSAGE);
	}

	public void printErrorLastWeekWinningNumberInvalidation() {
		System.out.println(ERROR_LAST_WEEK_WINNING_NUMBER_MESSAGE);
	}
}
