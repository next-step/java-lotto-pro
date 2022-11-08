package lotto.converter;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.TicketCount;
import lotto.exception.InvalidUserInputException;

public class InputConverter {

	private static final String DELIMITER = ",";
	private static final String BLANK_REGEX = "\\s";
	private static final String REPLACEMENT = "";

	private InputConverter() {
	}

	public static int toInt(String input) {
		validate(input);
		int integer;
		try {
			integer = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new InvalidUserInputException("숫자를 입력해주세요 : " + input);
		}
		return integer;
	}

	public static Money toMoney(String input) {
		return Money.from(((toInt(input)) / 100) * 100);
	}

	public static LottoNumbers toLottoNumbers(String input) {
		validate(input);
		String[] split = input.split(DELIMITER);
		return lottoNumbers(split);
	}

	public static LottoNumber toLottoNumber(String input) {
		validate(input);
		return LottoNumber.from(toInt(input));
	}

	public static TicketCount toLottoCount(String nextLine) {
		return TicketCount.from(toInt(nextLine));
	}

	private static LottoNumbers lottoNumbers(String[] split) {
		return Arrays.stream(split)
			.map(InputConverter::removeBlank)
			.map(InputConverter::toInt)
			.collect(Collectors.collectingAndThen(Collectors.toSet(), LottoNumbers::from));
	}

	private static String removeBlank(String input) {
		return input.replaceAll(BLANK_REGEX, REPLACEMENT);
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
