package lotto.domain;

import java.util.Objects;

public class Money {
	private static final int MIN_MONEY = 0;
	private static final String ERROR_MONEY_BOUNDARY = "돈은 0원보다 작을 수 없습니다.";
	private final int money;

	public Money(final int money) {
		validateMoney(money);
		this.money = money;
	}

	private void validateMoney(int money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_MONEY_BOUNDARY);
		}
	}

	public int getPurchaseQuantity(Money lottoPrice) {
		return divide(lottoPrice);
	}

	private int divide(Money lottoPrice) {
		return money / lottoPrice.money;
	}

	public int multiply(int size) {
		return money * size;
	}

	public boolean isLess(int purchaseAmount) {
		return purchaseAmount < money;
	}

	public int value() {
		return money;
	}

	public Money getPurchaseAmount(int inputQuantity) {
		return new Money(money * inputQuantity);
	}

	public boolean isGreater(Money purchaseAmount) {
		return money < purchaseAmount.money;
	}

	public Money deduct(Money inputPurchaseAmount) {
		return new Money(money - inputPurchaseAmount.money);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}


}
