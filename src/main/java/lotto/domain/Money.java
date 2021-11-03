package lotto.domain;

public class Money {
	private final int money;

	private Money(int money) {
		this.money = money;
	}

	public static Money of(int money) {
		return new Money(money);
	}
}
