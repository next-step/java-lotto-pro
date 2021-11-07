package lotto.domain;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	public Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public Lotto(int... lottoNumbers) {
		this(new LottoNumbers(lottoNumbers));
	}

	public MatchedNumber countMatchNumber(WinningNumbers winningNumbers) {
		int count = 0;
		for (Integer winningNumber : winningNumbers.value()) {
			count += lottoNumbers.isMatch(winningNumber);
		}
		return new MatchedNumber(count);
	}

	public String getLottoNumbersStringValues() {
		return lottoNumbers.StringValues();
	}
}
