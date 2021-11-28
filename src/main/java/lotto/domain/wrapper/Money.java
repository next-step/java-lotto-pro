package lotto.domain.wrapper;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	private final BigDecimal money;

	public Money() {
		this.money = BigDecimal.ZERO;
	}

	public Money(double money) {
		this.money = new BigDecimal(money);
	}

	public Money(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal get() {
		return this.money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Money))
			return false;
		Money money1 = (Money)o;
		return money.equals(money1.money);
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
