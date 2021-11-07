package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final String PURCHASE_AMOUNT_REQUEST = "구입 금액을 입력해주세요";

	public int purchaseMoneyAmount() {
		System.out.println(PURCHASE_AMOUNT_REQUEST);

		String input = userInput();

		return Integer.parseInt(input);
	}

	private String userInput() {
		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}
}
