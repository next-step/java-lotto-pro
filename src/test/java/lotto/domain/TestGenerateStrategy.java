package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.strategy.GenerateStrategy;

public class TestGenerateStrategy implements GenerateStrategy {

	// 1, 2, 3, 4, 5, 6
	@Override
	public LottoNumbers generate() {
		return LottoNumbers.from(IntStream.range(1, 7)
				.boxed()
				.collect(Collectors.toSet()));
	}
}
