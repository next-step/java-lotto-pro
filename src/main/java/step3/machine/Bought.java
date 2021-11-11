package step3.machine;

import step3.Money;

public class Bought {

	private Money money;
	private int manual;

	public Bought(Money money, int manual) {
		this.money = money;
		this.manual = manual;
	}

	public Bought(Money money) {
		this.money = money;
	}

	public int buyAutoCount() {
		return money.buyCount() - manual;
	}
}
