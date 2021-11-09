package lotto.view;

import java.util.Scanner;

import lotto.domain.LottoNumber;

public class InputView {
	public static final String REGEX_DELIMITER = ",";
	public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
		return Integer.parseInt(scanner.nextLine());
	}

	public static String[] inputLastWeekLottoNumber() {
		System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER);
		return scanner.nextLine().split(REGEX_DELIMITER);
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		return Integer.parseInt(scanner.next());
	}
}
