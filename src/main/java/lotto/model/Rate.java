package lotto.model;

import java.util.Objects;

public class Rate {

	private final double rate;

	public Rate(double rate) {
		this.rate = Math.floor(rate * 100) / 100;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Rate rate1 = (Rate)o;
		return Double.compare(rate1.rate, rate) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rate);
	}

	@Override
	public String toString() {
		return String.format("%.2f", rate);
	}
}
