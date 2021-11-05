package view;

import java.util.Scanner;

public class InputView {

	public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String LASE_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String ERROR_PURCHASE_AMOUNT_MESSAGE = "숫자를 입력해야 합니다.";
	public static final String ERROR_LAST_WEEK_WINNING_NUMBER_MESSAGE = "쉼표(,)로 구분된 6개의 숫자만 입력할 수 있습니다.";

	private static final Scanner sc = new Scanner(System.in);

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
