package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String COMMA = ",";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);
		int money = scanner.nextInt();
		scanner.nextLine();
		return money;
	}

	public static List<String> inputNumbers() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		String input = scanner.nextLine();
		String[] strNumbers = input.split(COMMA);

		List<String> numberList = new ArrayList<>();
		for(String number: strNumbers) {
			numberList.add(number.trim());
		}

		return numberList;
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		int number = scanner.nextInt();
		scanner.nextLine();

		return number;
	}
}
