package lotto;

public class LottoNumber implements Comparable<LottoNumber> {
	private final static int LOTTO_MIN_NUMBER = 1;
	private final static int LOTTO_MAX_NUMBER = 45;

	private final int number;

	public LottoNumber(final int number) {
		validate(number);
		this.number = number;
	}

	private void validate(final int number) {
		if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException("로또의 숫자 범위는 1~45 이다.");
		}
	}

	@Override
	public int compareTo(final LottoNumber otherNumber) {
		return Integer.compare(this.number, otherNumber.number);
	}
}
