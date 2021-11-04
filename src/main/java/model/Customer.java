package model;

import java.util.ArrayList;
import java.util.List;

final class Customer {

	private final List<Money> moneyHistory;

	private Customer(List<Money> moneyHistory) {
		this.moneyHistory = moneyHistory;
	}

	static Customer from(Money initialMoney) {
		validate(initialMoney);
		List<Money> moneyList = new ArrayList<>();
		moneyList.add(initialMoney);
		return new Customer(moneyList);
	}

	private static void validate(Money initialMoney) {
		if (initialMoney == null) {
			throw new IllegalArgumentException("'money' must not be empty");
		}
	}

	public boolean hasMoreThan(Money price) {
		return currentMoney()
			.moreThan(price);
	}

	public void subtractMoney(Money money) {
		if (hasLessThan(money)) {
			throw new IllegalStateException(
				String.format("too much subtract money(%s), not enough money(%s)", money, currentMoney()));
		}
		changeCurrentMoney(currentMoney()
			.subtract(money));
	}

	private Money currentMoney() {
		return moneyHistory.get(moneyHistory.size() - 1);
	}

	private boolean hasLessThan(Money money) {
		return !hasMoreThan(money);
	}

	private void changeCurrentMoney(Money money) {
		moneyHistory.add(money);
	}
}
