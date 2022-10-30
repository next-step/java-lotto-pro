package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ProfitMargin {

	private static final int SCALE = 2;

	private final BigDecimal margin;

	private ProfitMargin(BigDecimal profitMargin) {
		this.margin = profitMargin.setScale(SCALE, RoundingMode.DOWN);
	}

	public static ProfitMargin valueOf(BigDecimal profitMargin) {
		return new ProfitMargin(profitMargin);
	}

	public static ProfitMargin valueOf(double profitMargin) {
		return valueOf(BigDecimal.valueOf(profitMargin));
	}

	public boolean isLoss() {
		return margin.compareTo(BigDecimal.ONE) < 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProfitMargin that = (ProfitMargin)o;
		return margin.equals(that.margin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(margin);
	}

	@Override
	public String toString() {
		return margin.toString();
	}
}
