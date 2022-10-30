package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

	private static final Scanner scanner = new Scanner(System.in);

	public static String input() {
		return scanner.nextLine();
	}

	public static int inputInteger() {
		return Integer.parseInt(input());
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

	public static List<List<Integer>> inputIntegerListMany(int buyingManualLottoCount) {

		return inputMany(buyingManualLottoCount).stream()
			.map(StringSplitter::split)
			.map(splitStrings -> splitStrings.stream()
				.map(String::trim)
				.map(Integer::valueOf)
				.collect(Collectors.toList()))
			.collect(Collectors.toList());
	}

	private static List<String> inputMany(int count, List<String> inputs) {
		if (count == 0) {
			return inputs;
		}
		inputs.add(input());
		return inputMany(count - 1, inputs);
	}

}
