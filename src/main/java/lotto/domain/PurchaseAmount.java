package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
	public static final int SALE_PRICE = 1000;
	public static final int CHANGE = 0;
	public static final String INVALID_AMOUNT = "로또 한장에 " + SALE_PRICE + "원 입니다. 금액을 확인해주세요.";

	private final int amount;

	public PurchaseAmount(int money) {
		validationPurchaseAmount(money);
		this.amount = money;
	}

	private void validationPurchaseAmount(int money) {
		if (isNotAmountCorrect(money)) {
			throw new IllegalArgumentException(INVALID_AMOUNT);
		}
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
