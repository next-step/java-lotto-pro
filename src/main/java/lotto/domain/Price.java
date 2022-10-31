package lotto.domain;

import java.util.Objects;

public class Price {
	private final long price;

	private Price(long price) {
		this.price = price;
	}

	public static Price from(long price) {
		return new Price(price);
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
