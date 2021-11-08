package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	public static final int MIN_BOUND = 1;
	public static final int MAX_BOUND = 45;
	private static final String ERROR_LOTTO_NUMBER_BOUNDARY = "[ERROR] 로또번호는 1~45의 값을 가져야 합니다.";
	private static final String ERROR_LOTTO_NUMBER_VALUE = "[ERROR] 로또번호는 숫자만 입력가능합니다.";
	private final int lottoNumber;

	public LottoNumber(final int lottoNumber) {
		validateLottoNumberBoundary(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public LottoNumber(final String lottoNumber) {
		this(stringValueToIntValue(lottoNumber));
	}

	public int getValue() {
		return lottoNumber;
	}

	private void validateLottoNumberBoundary(int lottoNumber) {
		if (lottoNumber < MIN_BOUND || lottoNumber > MAX_BOUND) {
			throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_BOUNDARY);
		}
	}

	private static int stringValueToIntValue(String stringNumber) {
		try {
			return Integer.parseInt(stringNumber);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_VALUE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}
