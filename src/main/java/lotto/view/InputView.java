package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	public static String inputMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);
		return scanner.next();
	}

	public static String inputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		return scanner.next();
	}
}
