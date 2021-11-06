package lotto;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static String enterPurchaseAmount() {
		System.out.println(CommonMessage.ENTER_PURCHASE_AMOUNT);
		return scanner.nextLine();
	}

	public static String enterWinningNumbers() {
		System.out.println(CommonMessage.ENTER_WINNING_NUMBERS);
		return scanner.nextLine();
	}
}
