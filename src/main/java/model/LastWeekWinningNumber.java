package model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class LastWeekWinningNumber {
	private static final String NUMBER_REGEX = "^[0-9]+$";
	public static final String SPACE_REGEX = "\\s+";
	public static final String EMPTY_STRING = "";
	public static final String COMMA = ",";

	private Lotto value;

	private LastWeekWinningNumber(Lotto value) {
		this.value = value;
	}

	public static boolean validate(String value) {
		String[] strings = value.replaceAll(SPACE_REGEX, EMPTY_STRING)
			.split(COMMA);

		if (strings.length != Lotto.NUMBER_COUNT) {
			return false;
		}

		return Arrays.stream(strings)
			.allMatch(string -> string.matches(NUMBER_REGEX))
			&& isNotDuplicatedNumber(strings);
	}

	private static boolean isNotDuplicatedNumber(String[] strings) {
		int numbersCount = Arrays.stream(strings)
			.map(Integer::parseInt)
			.collect(toSet())
			.size();

		return numbersCount == Lotto.NUMBER_COUNT;
	}

	public static LastWeekWinningNumber of(String lastWeekWinningNumber) {
		List<Integer> numbers = Arrays.stream(splitToEachNumber(lastWeekWinningNumber))
			.map(Integer::parseInt)
			.collect(toList());

		return new LastWeekWinningNumber(new Lotto(numbers));
	}

	private static String[] splitToEachNumber(String lastWeekWinningNumber) {
		return lastWeekWinningNumber.replaceAll(SPACE_REGEX, EMPTY_STRING)
			.split(COMMA);
	}

	public Lotto getValue() {
		return value;
	}
}
