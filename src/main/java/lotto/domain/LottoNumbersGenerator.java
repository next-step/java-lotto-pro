package lotto.domain;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
	private static final Random RANDOM = new Random();
	private static final int MAX_LOTTO_NUMBER_SIZE = 6;
	private static final int MINIMUM_NUMBER_BOUND = 1;
	private static final int MAXIMUM_NUMBER_BOUND = 45;

	public Set<LottoNumber> generate() {
		return RANDOM.ints(MINIMUM_NUMBER_BOUND, MAXIMUM_NUMBER_BOUND)
			.distinct()
			.limit(MAX_LOTTO_NUMBER_SIZE)
			.boxed()
			.map(LottoNumber::of)
			.collect(Collectors.toSet());
	}
}
