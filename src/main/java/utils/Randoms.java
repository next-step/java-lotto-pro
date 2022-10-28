package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randoms {

	public static List<Integer> generateUniqueNumbers(int startInclusive, int endExclusive, int count) {
		verifyIsValidInput(startInclusive, endExclusive, count);

		List<Integer> numbers = generateNumbersInRange(startInclusive, endExclusive);
		Collections.shuffle(numbers);

		return numbers.subList(0, count);
	}

	private static void verifyIsValidInput(int startInclusive, int endExclusive, int count) {
		if (isCountInvalid(startInclusive, endExclusive, count)) {
			throw new IllegalArgumentException("생성 갯수는 범위보다 커야 합니다");
		}
		if (isRangeInvalid(startInclusive, endExclusive)) {
			throw new IllegalArgumentException("생성 범위는 0이거나 음수일 수 없습니다.");
		}
	}

	private static boolean isRangeInvalid(int startInclusive, int endExclusive) {
		return endExclusive <= startInclusive;
	}

	private static boolean isCountInvalid(int startInclusive, int endExclusive, int count) {
		return endExclusive - startInclusive < count;
	}

	private static List<Integer> generateNumbersInRange(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive)
			.boxed()
			.collect(Collectors.toList());
	}
}
