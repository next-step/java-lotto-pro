package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_MANUAL_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String EOL = "\n";
	private static final String COMMA = ",";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);
		int money = scanner.nextInt();
		scanner.nextLine();
		System.out.print(EOL);

		return money;
	}

	public static List<String> inputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

		return getNumbersFromString();
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		int number = scanner.nextInt();
		scanner.nextLine();
		System.out.print(EOL);

		return number;
	}

	public static int inputNumberOfAttempts() {
		System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
		int count = scanner.nextInt();
		scanner.nextLine();
		System.out.print(EOL);

		return count;
	}

	public static List<List<String>> inputManualNumbers(int manualCount) {
		System.out.println(INPUT_MANUAL_MESSAGE);

		List<List<String>> manualLottoList = new ArrayList<>();

		for(int index = 0; index < manualCount; index += 1) {
			manualLottoList.add(getNumbersFromString());
		}
		System.out.print(EOL);

		return manualLottoList;
	}

	private static List<String> getNumbersFromString() {
		String input = scanner.nextLine();
		String[] strNumbers = input.split(COMMA);

		List<String> numberList = new ArrayList<>();
		for(String number: strNumbers) {
			numberList.add(number.trim());
		}

		return numberList;
	}
}
