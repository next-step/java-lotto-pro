package lotto.domain;

import java.util.Objects;

public class Quantity {
	public static final String ERROR_SHORT_MONEY = "구매가능한 로또 수량을 초과하였습니다.";
	public static final int CORRECT = 0;

	private final int quantity;

	public Quantity(int quantity) {
		this.quantity = quantity;
		validation();
	}

	private void validation() {
		if(isOverQuantity()){
			throw new IllegalArgumentException(ERROR_SHORT_MONEY);
		}
	}

	private boolean isOverQuantity() {
		return this.quantity < CORRECT;
	}

	public int getQuantity() {
		return quantity;
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
