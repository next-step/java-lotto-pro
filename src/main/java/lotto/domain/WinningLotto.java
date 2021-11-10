package lotto.domain;

import java.util.stream.Stream;

public class WinningLotto {
	private final LottoNumbers winningNumbers;
	private final LottoNumber bonusBallNumber;

	public WinningLotto(final String winningNumbers, final int bonusBallNumber) {
		this.winningNumbers = new LottoNumbers(winningNumbers);
		this.bonusBallNumber = new LottoNumber(bonusBallNumber);
	}

	public Stream<LottoNumber> stream() {
		return winningNumbers.stream();
	}

	public LottoNumber getBonusBallNumber() {
		return bonusBallNumber;
	}
}
