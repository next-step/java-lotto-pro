package lotto.domain;

import lotto.domain.strategy.GenerateStrategy;

public class ManualGenerateStrategy implements GenerateStrategy {

	private final NumberReader<LottoNumbers> numberReader;

	public ManualGenerateStrategy(NumberReader<LottoNumbers> numberReader) {
		this.numberReader = numberReader;
	}

	@Override
	public LottoNumbers generate() {
		return numberReader.read();
	}
}
