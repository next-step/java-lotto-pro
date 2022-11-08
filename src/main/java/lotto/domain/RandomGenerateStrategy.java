package lotto.domain;

import java.util.Random;
import java.util.stream.Collectors;

import lotto.domain.strategy.GenerateStrategy;

public class RandomGenerateStrategy implements GenerateStrategy {
	private static final Random RANDOM = new Random();

	private RandomGenerateStrategy() {
	}

	private static class RandomGenerateStrategyHolder {
		private static final RandomGenerateStrategy INSTANCE = new RandomGenerateStrategy();
	}

	public static RandomGenerateStrategy getInstance() {
		return RandomGenerateStrategyHolder.INSTANCE;
	}

	@Override
	public LottoNumbers generate() {
		return RANDOM.ints(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
			.distinct()
			.limit(LottoNumbers.LOTTO_NUMBERS_COUNT)
			.boxed()
			.collect(Collectors.collectingAndThen(Collectors.toSet(), LottoNumbers::from));
	}
}
