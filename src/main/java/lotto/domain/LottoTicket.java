package lotto.domain;

import java.util.Objects;
import java.util.Set;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicket {
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private final LottoNumbers lottoNumbers;

	LottoTicket(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoTicket of(GenerateStrategy generator) {
		return new LottoTicket(generator.generate());
	}

	public static LottoTicket of(Set<Integer> lottoNumbers) {
		return new LottoTicket(LottoNumbers.of(lottoNumbers));
	}

	public LottoNumbers lottonumbers() {
		return lottoNumbers;
	}

	@Override
	public String toString() {
		return OPEN_BRACKET + lottoNumbers.toString() + CLOSE_BRACKET;
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
