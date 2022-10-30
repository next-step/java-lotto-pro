package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputHandler {

	private static final String NUMBER_INPUT_ERROR_MESSAGE = "숫자만 입력할 수 있습니다.";
	private static final String NUMBER_LIST_INPUT_ERROR_MESSAGE = "콤마로 구분된 숫자를 입력해야 합니다.";
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputInteger(String prompt) {
		return callHandlingException(
			prompt,
			NUMBER_INPUT_ERROR_MESSAGE,
			() -> Integer.parseInt(input()));
	}

	public static List<String> inputMany(int count) {
		return inputMany(count, new ArrayList<>(count));
	}

	public static List<Integer> inputIntegerList() {
		SplitStrings splitStrings = StringSplitter.split(input());

		return splitStrings.stream()
			.map(String::trim)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
	}

	public static List<List<Integer>> inputIntegerListMany(String prompt,
														   int buyingManualLottoCount) {
		return callHandlingException(prompt, NUMBER_LIST_INPUT_ERROR_MESSAGE, () ->
			inputMany(buyingManualLottoCount).stream()
				.map(StringSplitter::split)
				.map(splitStrings -> splitStrings.stream()
					.map(String::trim)
					.map(Integer::valueOf)
					.collect(Collectors.toList()))
				.collect(Collectors.toList())
		);
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

	private static <T> T callHandlingException(String prompt, String exceptionMessage, Supplier<T> supplier) {
		try {
			System.out.println(prompt);
			return supplier.get();
		} catch (Exception e) {
			System.out.println(exceptionMessage);
			return callHandlingException(prompt, exceptionMessage, supplier);
		}
	}

}
