package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	public Lotto(final int... lottoNumbers) {
		this(new LottoNumbers(lottoNumbers));
	}

	public Lotto(final String lottoNumbers) {
		this(new LottoNumbers(lottoNumbers));
	}

	public Lotto(final LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public long countMatchedNumber(WinningLotto winningLotto) {
		return this.lottoNumbers.stream()
			.filter((lottoNumber) -> winningLotto.stream()
				.anyMatch(winningNumber -> winningNumber.equals(lottoNumber)))
			.count();
	}

	public boolean isMatch(LottoNumber bonusBallNumber) {
		return this.lottoNumbers.stream()
			.anyMatch(lottoNumber -> lottoNumber.equals(bonusBallNumber));
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers.getLottoNumbers();
	}

	public Stream<LottoNumber> stream() {
		return lottoNumbers.stream();
	}

}
