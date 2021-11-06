package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>  {
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final int no;

	public LottoNumber(int no) {
		if (no < MIN_LOTTO_NUMBER || no > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("범위를 벗어난 로또번호 입니다 : "+no);
		}
		this.no = no;
	}

	@Override
	public int compareTo(LottoNumber number) {
		return Integer.parseInt(number.toString()) < no ? 1 : -1;
	}

	@Override
	public String toString() {
		return Integer.toString(no);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return no == that.no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}
}
