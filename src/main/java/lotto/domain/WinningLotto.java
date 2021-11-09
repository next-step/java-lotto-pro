package lotto.domain;

public class WinningLotto {
	private final LottoNumbers winningNumbers;
	private final LottoNumber bonusBallNumber;

	public WinningLotto(final String winningNumbers, final int bonusBallNumber) {
		this.winningNumbers = new LottoNumbers(winningNumbers);
		this.bonusBallNumber = new LottoNumber(bonusBallNumber);
	}
}
