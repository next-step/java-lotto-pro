package step3.lotto;

import java.util.Objects;

public class LottoNumber {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;

	protected final int no;

	public LottoNumber(int no) {
		this.no = no;
		validation();
	}

	private void validation() {
		if (no > MAX_NUMBER ||  no < MIN_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45까지 숫자이어야 합니다.");
		}
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

	@Override
	public String toString() {
		return String.valueOf(no);
	}
}
