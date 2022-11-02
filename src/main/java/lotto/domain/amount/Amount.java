package lotto.domain.amount;

import java.util.Objects;

public class Amount {
	private static final long MIN_PRICE_RANGE = 0;
	private final long amount;

	private Amount(long amount) {
		this.amount = amount;
	}

	public static Amount from(long price) {
		validateAmount(price);
		return new Amount(price);
	}

	private static void validateAmount(long price) {
		if (price < MIN_PRICE_RANGE) {
			throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
		}
	}

	public static Amount from(String price) {
		return new Amount(parseLong(price));
	}

	public static long parseLong(String price) {
		try {
			return Long.parseLong(price);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("금액은 숫자이어야 합니다.");
		}
	}

	public long getLong() {
		return this.amount;
	}

	public Amount sum(Amount other) {
		return new Amount(this.amount + other.amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Amount that = (Amount)o;
		return amount == that.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
