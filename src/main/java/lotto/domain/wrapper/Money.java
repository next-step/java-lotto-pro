package lotto.domain.wrapper;

public class Money {
	private static final int ZERO = 0;
	private final double money;

	public Money() {
		this.money = ZERO;
	}

	public Money(double money) {
		this.money = money;
	}

	public double get() {
		return this.money;
	}
}
