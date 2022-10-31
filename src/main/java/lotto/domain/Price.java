package lotto.domain;

import java.util.Objects;

public class Price {
	private final long price;

	private static final long MIN_PRICE = 0;

	private Price(long price) {
		this.price = price;
	}

	public static Price from(long price) {
		validatePrice(price);
		return new Price(price);
	}

	private static void validatePrice(long price) {
		if (price < MIN_PRICE) {
			throw new IllegalArgumentException("구매 금액은 음수일 수 없습니다.");
		}
	}

	public static Price from(String price) {
		return new Price(parseLong(price));
	}

	public static long parseLong(String price) {
		try {
			return Long.parseLong(price);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("금액은 숫자이어야 합니다.");
		}
	}

	public long getLong() {
		return this.price;
	}

	public Price sum(Price other) {
		return new Price(this.price + other.price);
	}

	public float div(int quantity) {
		return (float)this.price / quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Price that = (Price)o;
		return price == that.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price);
	}
}
