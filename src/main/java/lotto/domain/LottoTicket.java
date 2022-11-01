package lotto.domain;

import java.util.Objects;
import java.util.Set;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicket {
	private final LottoNumbers lottoNumbers;

	LottoTicket(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoTicket from(GenerateStrategy generator) {
		return new LottoTicket(generator.generate());
	}

	public static LottoTicket from(Set<Integer> lottoNumbers) {
		return new LottoTicket(LottoNumbers.from(lottoNumbers));
	}

	public LottoNumbers lottonumbers() {
		return lottoNumbers;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return "[" + lottoNumbers.toString() + "]";
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
