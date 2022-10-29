package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ProfitMargin {

	private static final int SCALE = 2;

	private final BigDecimal profitMargin;

	private ProfitMargin(BigDecimal profitMargin) {
		this.profitMargin = profitMargin.setScale(SCALE, RoundingMode.DOWN);
	}

	public static ProfitMargin valueOf(BigDecimal profitMargin) {
		return new ProfitMargin(profitMargin);
	}

	public static ProfitMargin valueOf(double profitMargin) {
		return valueOf(BigDecimal.valueOf(profitMargin));
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
		return profitMargin.equals(that.profitMargin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(profitMargin);
	}

	@Override
	public String toString() {
		return profitMargin.toString();
	}

	public boolean isProfitDecimal() {
		return profitMargin.compareTo(BigDecimal.ONE) < 0 &&
			profitMargin.compareTo(BigDecimal.ZERO) > 0;
	}
}
