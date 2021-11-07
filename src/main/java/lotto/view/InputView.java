package lotto.view;

import java.util.Scanner;

public class InputView {
	public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public String inputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
		return scanner.nextLine();
	}

	public String inputLastWeekLottoNumber() {
		System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER);
		return scanner.nextLine();
	}
}
