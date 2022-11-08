package lotto.domain;

import lotto.domain.strategy.GenerateStrategy;

public class ManualGenerateStrategy implements GenerateStrategy {

	private final LottoNumbers lottoNumbers;

	private ManualGenerateStrategy(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static ManualGenerateStrategy from(LottoNumbers lottoNumbers) {
		return new ManualGenerateStrategy(lottoNumbers);
	}

	@Override
	public LottoNumbers generate() {
		return this.lottoNumbers;
	}
}
