package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>  {
	private final int no;

	public LottoNumber(int no) {
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
