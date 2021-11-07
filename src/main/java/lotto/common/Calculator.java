package lotto.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

	public static final int DECIMAL_POINT = 2;

	public static double profitRate(double initial, double review) {
		return new BigDecimal(review / initial)
			.setScale(DECIMAL_POINT, RoundingMode.FLOOR)
			.doubleValue();
	}
}
