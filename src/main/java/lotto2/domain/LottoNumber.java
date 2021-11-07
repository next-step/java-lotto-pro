package lotto2.domain;

public class LottoNumber {

	private static final int LOTTO_NUMBER_MIN = 1;
	private static final int LOTTO_NUMBER_MAX = 45;
	private int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static void validate(int number) {
		if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
			throw new IllegalArgumentException("로또번호는 1~45번호이여야 합니다");
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
