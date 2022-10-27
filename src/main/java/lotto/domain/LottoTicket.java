package lotto.domain;

import java.util.Objects;

public class LottoTicket {
	private final LottoNumbers lottoNumbers;

	private LottoTicket(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoTicket of(LottoNumbers lottoNumbers) {
		return new LottoTicket(lottoNumbers);
	}

	public static LottoTicket of(LottoNumbersGenerator lottoNumbersGenerator) {
		return new LottoTicket(LottoNumbers.of(lottoNumbersGenerator.generate()));
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
