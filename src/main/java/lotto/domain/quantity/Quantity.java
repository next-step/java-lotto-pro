package lotto.domain.quantity;

import java.util.Objects;

public class Quantity {
	private static final int MIN_QUANTITY_RANGE = 0;
	private final int quantity;

	private Quantity(int quantity) {
		validateRange(quantity);
		this.quantity = quantity;
	}

	public static Quantity from(int quantity) {
		return new Quantity(quantity);
	}

	private void validateRange(int quantity) {
		if (quantity < MIN_QUANTITY_RANGE) {
			throw new IllegalArgumentException("갯수는 0 미만일 수 없습니다.");
		}
	}

	public int getInt() {
		return this.quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Quantity quantity1 = (Quantity)o;
		return quantity == quantity1.quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(quantity);
	}
}
