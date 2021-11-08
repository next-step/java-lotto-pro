package lotto.domain;

import java.util.List;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	public Lotto(int... lottoNumbers) {
		this(new LottoNumbers(lottoNumbers));
	}

	public Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public int countMatchNumber(WinningNumbers winningNumbers) {
		int count = 0;
		for (Integer winningNumber : winningNumbers.value()) {
			count += lottoNumbers.isMatch(winningNumber);
		}
		return count;
	}

	public List<String> getLottoNumbersStringValues() {
		return lottoNumbers.StringValues();
	}
}
