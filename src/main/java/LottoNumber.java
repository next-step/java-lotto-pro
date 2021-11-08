import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	public final static int MIN_INCLUSIVE_NUMBER = 1;
	public final static int MAX_INCLUSIVE_NUMBER = 45;

	private final int number;

	private LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (number < MIN_INCLUSIVE_NUMBER || MAX_INCLUSIVE_NUMBER < number) {
			throw new LottoNumberFormatException();
		}
	}

	public static LottoNumber from(int number) {
		return new LottoNumber(number);
	}

	public static LottoNumber from(String s) {
		validate(s);
		return from(Integer.parseInt(s.trim()));
	}

	private static void validate(String s) {
		if (null == s) {
			throw new LottoNumberFormatException();
		}
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new LottoNumberFormatException();
		}
	}

	public int get() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LottoNumber))
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int compareTo(LottoNumber other) {
		return number - other.number;
	}
}
