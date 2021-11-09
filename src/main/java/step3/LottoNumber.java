package step3;

import java.util.Objects;

public class LottoNumber {

	protected final int no;

	public LottoNumber(int no) {
		this.no = no;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		LottoNumber that = (LottoNumber)o;
		return no == that.no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	@Override
	public String toString() {
		return String.valueOf(no);
	}
}
