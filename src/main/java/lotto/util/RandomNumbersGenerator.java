package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {
	private static final int SIZE_MIN_NUMBER = 0;

	public static List<Integer> generate(final int first, final int last, final int size) {
		validateRange(first, last);
		validateSize(first, last, size);

		List<Integer> list = IntStream.rangeClosed(first, last).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		return list.subList(0, size);
	}

	private static void validateRange(final int first, final int last) {
		if (first > last) {
			throw new IllegalArgumentException("first가 last보다 클 수는 없습니다.");
		}
	}

	private static void validateSize(final int first, final int last, final int size) {
		if (size < SIZE_MIN_NUMBER) {
			throw new IllegalArgumentException("size가 0보다 작을 수는 없습니다.");
		}

		if (size > (last - first + 1)) {
			throw new IllegalArgumentException("begin ~ last 범위 사이의 숫자_갯수가 size보다 작습니다.");
		}
	}
}
