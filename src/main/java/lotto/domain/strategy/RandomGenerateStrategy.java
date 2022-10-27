package lotto.domain.strategy;

import java.util.Random;
import java.util.stream.Collectors;

import lotto.domain.LottoNumbers;

public class RandomGenerateStrategy implements GenerateStrategy {
	private static final Random RANDOM = new Random();
	private static final int MAX_LOTTO_NUMBER_SIZE = 6;
	private static final int MINIMUM_NUMBER_BOUND = 1;
	private static final int MAXIMUM_NUMBER_BOUND = 45;

	@Override
	public LottoNumbers generate() {
		return RANDOM.ints(MINIMUM_NUMBER_BOUND, MAXIMUM_NUMBER_BOUND)
			.distinct()
			.limit(MAX_LOTTO_NUMBER_SIZE)
			.boxed()
			.collect(Collectors.collectingAndThen(Collectors.toSet(), LottoNumbers::of));
	}
}
