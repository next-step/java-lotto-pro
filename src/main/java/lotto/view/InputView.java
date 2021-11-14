package lotto.view;

import static java.lang.Integer.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
	public static final String REGEX_DELIMITER = ",";
	public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	public static final String INPUT_MANUAL_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String ERROR_NUMBER_FORMAT = "문자가 입력되었습니다. 숫자만 입력해주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
		return parseInt(scanner.next());
	}

	public static List<Integer> inputLastWeekLottoNumber() {
		System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER);
		try {
			return Stream.of(scanner.next().split(REGEX_DELIMITER))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(ERROR_NUMBER_FORMAT);
		}
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		return parseInt(scanner.next());
	}

	public static int inputManualLottoQuantity() {
		System.out.println(INPUT_MANUAL_NUMBER);
		try {
			return Integer.parseInt(scanner.next());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(ERROR_NUMBER_FORMAT);
		}
	}

	public static List<Integer> inputManualNumbers() {
		try {
			return Stream.of(scanner.next().split(REGEX_DELIMITER))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(ERROR_NUMBER_FORMAT);
		}
	}
}
