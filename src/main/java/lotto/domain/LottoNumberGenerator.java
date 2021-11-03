package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

	private static final List<Integer> candidates = new ArrayList<>();

	static {
		for (int i = LottoNumber.LOTTO_NUMBER_MINIMUM; i <= LottoNumber.LOTTO_NUMBER_MAXIMUM; i++) {
			candidates.add(i);
		}
	}

	public static LottoNumber generate() {
		Collections.shuffle(candidates);
		List<Integer> numbers = new ArrayList<>(candidates.subList(0, LottoNumber.LOTTO_NUMBER_SIZE));
		return new LottoNumber(numbers);
	}

}
