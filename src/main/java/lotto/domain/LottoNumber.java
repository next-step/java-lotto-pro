package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoNumberConstant.*;

import lotto.utils.MessageBuilder;

public class LottoNumber {
	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(int number) {
		validateLottoNumber(number);
		return new LottoNumber(number);
	}

	private static void validateLottoNumber(int number) {
		if (LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX) {
			return;
		}

		throw new IllegalArgumentException(MessageBuilder.build(INVALID_LOTTO_NUMBER, number));
	}

	public int getNumber() {
		return this.number;
	}
}
