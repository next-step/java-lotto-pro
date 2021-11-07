package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

	private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

	private LottoGenerator() {
	}

	static {
		for (int i = Common.NUMBER_RANGE_MIN; i <= Common.NUMBER_RANGE_MAX; i++) {
			LOTTO_NUMBERS.add(i);
		}
	}

	public static Lotto generate() {
		Collections.shuffle(LOTTO_NUMBERS);
		List<Integer> lottoNumbers = LOTTO_NUMBERS.subList(0, Common.LOTTO_NUMBER_COUNT);
		Collections.sort(lottoNumbers);

		return Lotto.from(lottoNumbers);
	}
}
