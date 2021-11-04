package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;

import java.util.Objects;

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
		if (isValidLottoNumber(number)) {
			return;
		}

		throw new IllegalArgumentException(MessageBuilder.build(INVALID_LOTTO_NUMBER, number));
	}

	private static boolean isValidLottoNumber(int number) {
		return LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX;
	}

	public int getNumber() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
