package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int NUMBER_RANGE_MIN = 1;
	private static final int NUMBER_RANGE_MAX = 45;

	private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

	private LottoGenerator() {
	}

	static {
		for (int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
			LOTTO_NUMBERS.add(i);
		}
	}

	public static Lotto generate() {
		Collections.shuffle(LOTTO_NUMBERS);
		List<Integer> lottoNumbers = LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_COUNT);
		Collections.sort(lottoNumbers);

		return new Lotto(lottoNumbers);
	}
}
