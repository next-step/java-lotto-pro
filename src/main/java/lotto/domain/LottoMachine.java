package lotto.domain;

public class LottoMachine {
	private LottoNumberStrategy lottoNumberStrategy;

	public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
		this.lottoNumberStrategy = lottoNumberStrategy;
	}

	public Lotto generate() {
		return new Lotto(lottoNumberStrategy.generate(Lotto.LOTTO_SIZE));
	}
}
