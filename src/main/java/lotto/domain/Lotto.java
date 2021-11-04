package lotto.domain;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	private Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto of(LottoNumbers lottoNumbers) {
		return new Lotto(lottoNumbers);
	}

	public int countWinningNumbers(LottoNumbers lastWinningNumbers) {
		return this.lottoNumbers.countWinningNumbers(lastWinningNumbers);
	}

	public int getNumberSize() {
		return this.lottoNumbers.getSize();
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}
}
