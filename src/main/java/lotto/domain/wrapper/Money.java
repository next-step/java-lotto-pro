package lotto.domain.wrapper;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Money))
			return false;
		Money money1 = (Money)o;
		return Double.compare(money1.money, money) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
