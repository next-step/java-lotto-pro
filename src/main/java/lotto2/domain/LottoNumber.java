package lotto2.domain;

public class LottoNumber {

	public static final int LOTTO_NUMBER_MINIMUM = 1;
	public static final int LOTTO_NUMBER_MAXIMUM = 45;
	private int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static void validate(int number) {
		if (number < LOTTO_NUMBER_MINIMUM || number > LOTTO_NUMBER_MAXIMUM) {
			throw new IllegalArgumentException(
				ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.value());
		}
	}

	public static LottoNumber of(int number) {
		validate(number);
		return new LottoNumber(number);
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
		return number;
	}
}
