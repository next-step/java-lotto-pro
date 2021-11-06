package utils;

import java.util.Random;

// from Nextstep Randoms
public class RandomNumber {
	private static final Random RANDOM = new Random();

	public static int pickBetweenStartAndEnt(int start, int end) {
		validate(start, end);
		return start + RANDOM.nextInt(end - start + 1);
	}

	private static void validate(final int start, final int end) {
		if (end == Integer.MAX_VALUE) {
			throw new IllegalArgumentException("마지막값이 너무 큽니다.");
		}

		if (end - start >= Integer.MAX_VALUE) {
			throw new IllegalArgumentException("범위가 너무 큽니다.");
		}

		if (start > end) {
			throw new IllegalArgumentException("시작값보다 마지막값이 클 수 없습니다.");
		}
	}
}
