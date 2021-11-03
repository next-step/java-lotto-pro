package lotto.domain;

public class Lotto {
	private final LottoNumbers lottoNumbers;
	private final WinningNumbers winningNumbers;

	private Lotto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		this.winningNumbers = WinningNumbers.createDefault();
	}

	public static Lotto of(LottoNumbers lottoNumbers) {
		return new Lotto(lottoNumbers);
	}

	public void checkWinningNumbers(WinningNumbers lastWinningNumbers) {
		for (LottoNumber lottoNumber : this.lottoNumbers.getValues()) {
			addWinningNumbers(lastWinningNumbers, lottoNumber);
		}
	}

	public boolean isWinning() {
		return this.winningNumbers.isWinning();
	}

	public int getNumberSize() {
		return this.lottoNumbers.getSize();
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}

	private void addWinningNumbers(WinningNumbers lastWinningNumbers, LottoNumber lottoNumber) {
		if (lastWinningNumbers.isWinningNumber(lottoNumber)) {
			this.winningNumbers.add(lottoNumber);
		}
	}
}
