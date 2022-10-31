package lotto.domain.strategy;

import java.util.Random;
import java.util.stream.Collectors;

import lotto.domain.LottoInfo;
import lotto.domain.LottoNumbers;

public class RandomGenerateStrategy implements GenerateStrategy {
	private static final Random RANDOM = new Random();

	@Override
	public LottoNumbers generate() {
		return RANDOM.ints(LottoInfo.MIN_LOTTO_NUMBER.getValue(), LottoInfo.MAX_LOTTO_NUMBER.getValue())
			.distinct()
			.limit(LottoInfo.MAX_LOTTO_NUMBER_SIZE.getValue())
			.boxed()
			.collect(Collectors.collectingAndThen(Collectors.toSet(), LottoNumbers::from));
	}
}
