package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String PURCHASE_AMOUNT_REQUEST = "구입 금액을 입력해주세요";
	private static final String PREV_WINNING_NUMBERS_REQUEST = "지난주 당첨 번호를 입력해 주세요";
	private static final String NUMBER_DELIMITER = ",";
	private static final String BONUS_NUMBER_REQUEST = "보너스 볼을 입력해주세요";
	private static final String MANUAL_LOTTO_COUNT_REQUEST = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MANUAL_NUMBERS_REQUEST = "수동으로 구매할 번호를 입력해 주세요.";

	public int purchaseMoneyAmount() {
		System.out.println(PURCHASE_AMOUNT_REQUEST);

		String input = userInput();

		return Integer.parseInt(input);
	}

	public int manualLottoCount() {
		System.out.println(MANUAL_LOTTO_COUNT_REQUEST);

		String input = userInput();

		return Integer.parseInt(input);
	}

	public List<List<Integer>> manualLottoNumbers(final int manualCount) {
		System.out.println(MANUAL_NUMBERS_REQUEST);

		List<String> inputs = userInputs(manualCount);

		return inputs.stream()
			.map(s -> s.split(NUMBER_DELIMITER))
			.map(this::convertIntegers)
			.collect(Collectors.toList());
	}

	public List<Integer> previousWinningNumber() {
		System.out.println(PREV_WINNING_NUMBERS_REQUEST);

		String input = userInput();

		return convertIntegers(input.split(NUMBER_DELIMITER));
	}

	public int bonusNumber() {
		System.out.println(BONUS_NUMBER_REQUEST);

		String input = userInput();

		return Integer.parseInt(input);
	}

	private List<Integer> convertIntegers(String[] values) {
		return Arrays.stream(values)
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private List<String> userInputs(int count) {
		List<String> inputs = new ArrayList<>();

		for(int i = 0; i < count; i++) {
			inputs.add(userInput());
		}
		return inputs;
	}

	private String userInput() {
		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}
}
