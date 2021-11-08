package view;

import java.util.Scanner;

public class InputView {
	public static final String MESSAGE_REQUEST_INPUT_OF_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
	public static final String MESSAGE_REQUEST_INPUT_OF_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

	public void showRequestInputOfPurchasePrice() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_PURCHASE_PRICE);
	}

	public void showRequestInputOfWinningNumbers() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_WINNING_NUMBERS);
	}

	public String pollInput() {
		return new Scanner(System.in).nextLine();
	}
}
