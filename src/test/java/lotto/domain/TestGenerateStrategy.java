package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.strategy.GenerateStrategy;

public class TestGenerateStrategy implements GenerateStrategy {

	@Override
	public LottoNumbers generate() {
		return LottoNumbers.of(IntStream.range(1, 7)
				.boxed()
				.collect(Collectors.toSet()));
	}
}
