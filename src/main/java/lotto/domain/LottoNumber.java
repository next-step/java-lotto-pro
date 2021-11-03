package lotto.domain;

import lotto.utils.LottoNumberValidator;

public class LottoNumber {
	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(int number) {
		LottoNumberValidator.validateLottoNumber(number);
		return new LottoNumber(number);
	}

	public int getNumber() {
		return this.number;
	}
}
