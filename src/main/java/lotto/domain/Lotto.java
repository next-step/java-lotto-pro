package lotto.domain;

import java.util.List;

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

	public int countMatchNumber(WinningNumbers winningNumbers) {
		int count = 0;
		for (Integer winningNumber : winningNumbers.value()) {
			count += lottoNumbers.ifMatchCount(winningNumber);
		}
		return count;
	}

	public List<String> getLottoNumbersStringValues() {
		return lottoNumbers.getStringValues();
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers.getLottoNumbers();
	}
}
