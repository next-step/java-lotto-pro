package lotto.model;

import static lotto.constants.LottoConstants.*;

public class BonusNumber {

	private final int number;

	public BonusNumber(int number) {
		if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER)) {
			throw new IllegalArgumentException("Lotto number must be between 1 and 45");
		}

		this.number = number;
	}

	public boolean isInLotto(Lotto lotto) {
		return lotto.contains(number);
	}
}
