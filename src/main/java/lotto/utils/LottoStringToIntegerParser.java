package lotto.utils;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class LottoStringToIntegerParser {

	private LottoStringToIntegerParser() {}

	public static List<Integer> parseNumbers(String[] numbers) {
		return Arrays.stream(numbers)
					 .map(String::trim)
					 .map(Integer::parseInt)
					 .collect(toList());
	}

	public static int parse(String number) {
		return Integer.parseInt(number.trim());
	}
}
