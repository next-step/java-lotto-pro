package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
	public static final int SALE_PRICE = 1000;
	public static final int CHANGE = 0;

	private final int amount;

	public PurchaseAmount(int money) {
		if (isNotAmountCorrect(money)) {
			throw new IllegalArgumentException("##");
		}
		this.amount = money;
	}

	private boolean isNotAmountCorrect(int amount) {
		return amount % SALE_PRICE != CHANGE;
	}

	public int getPurchaseQuantity() {
		return this.amount / SALE_PRICE;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PurchaseAmount money1 = (PurchaseAmount)o;
		return amount == money1.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
