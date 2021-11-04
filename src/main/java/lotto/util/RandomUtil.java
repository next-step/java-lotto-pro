package lotto.util;

import java.util.Random;

import lotto.model.LottoNumber;

public class RandomUtil {
	private static final Random RANDOM = new Random();

	public static int pickNumber(final int min, final int max) {
		validMinMaxRange(min, max);
		return min + RANDOM.nextInt(max - min + 1);
	}

	private static void validMinMaxRange(final int min, final int max) {
		if (min < LottoNumber.MIN_LOTTO_NUMBER || max > LottoNumber.MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException();
		}
	}
}
