package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	private static final int MIN_MONEY = 0;
	private static final String ERROR_MONEY_BOUNDARY = "돈은 0원보다 작을 수 없습니다.";
	private final BigDecimal money;

	public Money(final int money) {
		validateMoney(money);
		this.money = new BigDecimal(String.valueOf(money));
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
		return money.divide(lottoPrice.money, 0).intValue();
	}

	public int multiply(int value) {
		return money.multiply(new BigDecimal(String.valueOf(value))).intValue();
	}

	public boolean isLess(int purchaseAmount) {
		return money.compareTo(new BigDecimal(purchaseAmount)) == 1;
	}

	public int value() {
		return money.intValue();
	}

	public Money getPurchaseAmount(int inputQuantity) {
		return new Money(multiply(inputQuantity));
	}

	public boolean isGreater(Money purchaseAmount) {
		return money.compareTo(purchaseAmount.money) == -1;
	}

	public Money deduct(Money inputPurchaseAmount) {
		return new Money(money.subtract(inputPurchaseAmount.money).intValue());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return Objects.equals(money, money1.money);
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
