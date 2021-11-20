package lotto.domain.wrapper;

public class Money {
	private final double money;

	public Money(double money) {
		this.money = money;
	}

	public double get() {
		return this.money;
	}
}
