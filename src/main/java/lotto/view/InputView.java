package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public static String enterPurchaseAmount() {
		System.out.println(ENTER_PURCHASE_AMOUNT);
		return scanner.nextLine();
	}

	public static String enterWinningNumbers() {
		System.out.println(ENTER_WINNING_NUMBERS);
		return scanner.nextLine();
	}
}
