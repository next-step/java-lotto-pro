package model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LastWeekWinningNumber {
	private static final String NUMBER_REGEX = "^[0-9]+$";
	public static final String SPACE_REGEX = "\\s+";
	public static final String EMPTY_STRING = "";
	public static final String COMMA = ",";

	private Lotto value;
	private BonusBall bonusBall;

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
			&& isValidNumber(strings);
	}

	private static boolean isValidNumber(String[] strings) {
		Set<Integer> numbers = Arrays.stream(strings)
			.map(Integer::parseInt)
			.collect(toSet());

		return Lotto.isNotDuplicatedNumber(numbers)
			&& Lotto.isValidLottoNumber(numbers);
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

	public void updateBonusBall(BonusBall bonusBall) {
		this.bonusBall = bonusBall;
	}

	public Lotto getValue() {
		return value;
	}

	public BonusBall getBonusBall() {
		return bonusBall;
	}
}
