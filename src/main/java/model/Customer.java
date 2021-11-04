package model;

final class Customer {

	private Money money;

	private Customer(Money money) {
		validate(money);
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

	private void validate(Money initialMoney) {
		if (initialMoney == null) {
			throw new IllegalArgumentException("'money' must not be empty");
		}
	}

	private boolean hasLessThan(Money money) {
		return !this.money.moreThan(money);
	}
}
