package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Prices {
	private final List<Price> prices;

	private Prices(List<Price> prices) {
		this.prices = prices;
	}

	public static Prices from(List<Price> prices) {
		return new Prices(prices);
	}

	public Price totalPrice() {
		return this.prices.stream()
			.reduce(Price::sum)
			.orElse(Price.from(0));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Prices that = (Prices)o;
		return Objects.equals(prices, that.prices);
	}

	@Override
	public int hashCode() {
		return Objects.hash(prices);
	}
}
