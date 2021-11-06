package lotto;

import java.util.Scanner;

public class InputView {
	private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

	private static Scanner scanner = new Scanner(System.in);

	public static String enterPurchaseAmount() {
		System.out.println(enterPurchaseAmount());
		return scanner.nextLine();
	}
}
