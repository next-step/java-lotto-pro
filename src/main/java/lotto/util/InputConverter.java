package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.LottoNumbers;
import lotto.exception.InvalidUserInputException;

public class InputConverter {

	private InputConverter() {
	}

	public static int toInt(String input) {
		validate(input);
		int integer;
		try {
			integer = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new InvalidUserInputException("숫자를 입력해주세요.");
		}
		return integer;
	}

	public static LottoNumbers toLottoNumbers(String input) {
		validate(input);
		String[] split = input.split(",");
		Set<Integer> numbers = toNumbers(split);
		return LottoNumbers.of(numbers);
	}

	private static Set<Integer> toNumbers(String[] split) {
		return Arrays.stream(split)
			.map(InputConverter::removeBlank)
			.map(InputConverter::toInt)
			.collect(Collectors.toSet());
	}

	private static String removeBlank(String input) {
		return input.replaceAll("\\s", "");
	}

	private static void validate(String input) {
		if (isBlank(input)) {
			throw new InvalidUserInputException("입력값이 없습니다.");
		}
	}

	private static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}

}
