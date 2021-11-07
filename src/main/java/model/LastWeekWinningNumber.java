package model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LastWeekWinningNumber {
	public static final String EMPTY_STRING = "";
	public static final String COMMA = ",";

	private Lotto lotto;
	private BonusBall bonusBall;

	private LastWeekWinningNumber(Lotto lotto) {
		this.lotto = lotto;
	}

	public static boolean validate(String value) {
		String[] strings = value.replaceAll(Regex.SPACE, EMPTY_STRING)
			.split(COMMA);

		if (strings.length != Lotto.NUMBER_COUNT) {
			return false;
		}

		return Arrays.stream(strings)
			.allMatch(string -> string.matches(Regex.NUMBER))
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
		return lastWeekWinningNumber.replaceAll(Regex.SPACE, EMPTY_STRING)
			.split(COMMA);
	}

	public void updateBonusBall(BonusBall bonusBall) {
		this.bonusBall = bonusBall;
	}

	public boolean isNotContain(String bonusBall) {
		return lotto.isNotContain(BonusBall.from(bonusBall));
	}

	public Lotto getLotto() {
		return lotto;
	}

	public BonusBall getBonusBall() {
		return bonusBall;
	}
}
