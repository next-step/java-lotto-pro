package model;

import utility.Assert;

final class Customer {

	private Money money;

	private Customer(Money money) {
		Assert.notNull(money, "'money' must not be empty");
		this.money = money;
	}

	static Customer from(Money initialMoney) {
		return new Customer(initialMoney);
	}

	int availablePurchaseCount(Money price) {
		return money.divide(price);
	}

	void subtractMoney(Money money) {
		if (hasLessThan(money)) {
			throw new IllegalStateException(
				String.format("too much subtract money(%s), not enough money(%s)", money, this.money));
		}
		this.money = this.money.subtract(money);
	}

	@Override
	public String toString() {
		return "Customer{" +
			"money=" + money +
			'}';
	}

	private boolean hasLessThan(Money money) {
		return !this.money.moreThan(money);
	}
}
