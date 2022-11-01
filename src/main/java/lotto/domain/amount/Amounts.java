package lotto.domain.amount;

import java.util.List;
import java.util.Objects;

public class Amounts {
	private static final long EMPTY_AMOUNTS_SUM = 0;
	private final List<Amount> amounts;

	private Amounts(List<Amount> amounts) {
		this.amounts = amounts;
	}

	public static Amounts from(List<Amount> amounts) {
		return new Amounts(amounts);
	}

	public Amount totalPrice() {
		return this.amounts.stream()
			.reduce(Amount::sum)
			.orElse(Amount.from(EMPTY_AMOUNTS_SUM));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Amounts that = (Amounts)o;
		return Objects.equals(amounts, that.amounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amounts);
	}
}
