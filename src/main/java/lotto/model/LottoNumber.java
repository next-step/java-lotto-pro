package lotto.model;

import java.util.Objects;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;
import lotto.util.RandomUtil;

public class LottoNumber {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber from() {
		int number = RandomUtil.pickNumber(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
		isNumberInLottoNumberRange(number);
		return new LottoNumber(number);
	}

	public static LottoNumber from(int number) {
		isNumberInLottoNumberRange(number);
		return new LottoNumber(number);
	}

	public static LottoNumber from(String number) {
		int parseInt = Integer.parseInt(number);
		isNumberInLottoNumberRange(parseInt);
		return new LottoNumber(parseInt);
	}

	private static void isNumberInLottoNumberRange(int number) {
		if (validLottoNumber(number)) {
			throw new LottoException(ErrorCode.OUT_OF_LOTTO_NUMBER_RANGE_ERROR);
		}
	}

	private static boolean validLottoNumber(int number) {
		return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
	}

	public int toInt() {
		return number;
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
