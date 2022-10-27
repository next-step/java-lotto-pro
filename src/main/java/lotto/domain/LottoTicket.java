package lotto.domain;

import java.util.Objects;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicket {
	private final LottoNumbers lottoNumbers;

	private LottoTicket(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoTicket of(GenerateStrategy generator) {
		return new LottoTicket(generator.generate());
	}

	public LottoNumbers getNumbers() {
		return lottoNumbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoTicket that = (LottoTicket)o;

		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
	}
}
