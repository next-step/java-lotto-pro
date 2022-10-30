package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

	private static final String NUMBER_INPUT_ERROR_MESSAGE = "숫자만 입력할 수 있습니다.";
	private static final String NUMBER_LIST_INPUT_ERROR_MESSAGE = "콤마로 구분된 숫자를 입력해야 합니다.";
	private static final Scanner scanner = new Scanner(System.in);
	public static final int ZERO = 0;
	public static final String POSITIVE_NUMBER_ERROR_MESSAGE = "음수는 입력할 수 없습니다.";

	public static int inputPositiveInteger(String prompt) {
		return ExceptionHandler.callWithHandlingException(
			prompt,
			() -> parsePositiveInteger(input()));
	}

	public static List<Integer> inputPositiveIntegerList(String prompt) {
		return ExceptionHandler.callWithHandlingException(prompt, NUMBER_LIST_INPUT_ERROR_MESSAGE, () -> {
			SplitStrings splitStrings = StringSplitter.split(input());

			return splitStrings.stream()
				.map(String::trim)
				.map(InputHandler::parsePositiveInteger)
				.collect(Collectors.toList());
		});
	}

	public static List<List<Integer>> inputPositiveIntegerListMany(String prompt,
																   int buyingManualLottoCount) {
		return ExceptionHandler.callWithHandlingException(prompt, NUMBER_LIST_INPUT_ERROR_MESSAGE, () ->
			inputMany(buyingManualLottoCount).stream()
				.map(StringSplitter::split)
				.map(splitStrings -> splitStrings.stream()
					.map(String::trim)
					.map(InputHandler::parsePositiveInteger)
					.collect(Collectors.toList()))
				.collect(Collectors.toList())
		);
	}

	private static int parsePositiveInteger(String input) {
		int intNumber = parseInteger(input);
		if (intNumber < ZERO) {
			throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR_MESSAGE);
		}
		return intNumber;
	}

	private static int parseInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_INPUT_ERROR_MESSAGE);
		}
	}

	private static List<String> inputMany(int count) {
		return inputMany(count, new ArrayList<>(count));
	}

	private static String input() {
		return scanner.nextLine();
	}

	private static List<String> inputMany(int count, List<String> inputs) {
		if (count == 0) {
			return inputs;
		}
		inputs.add(input());
		return inputMany(count - 1, inputs);
	}

}
