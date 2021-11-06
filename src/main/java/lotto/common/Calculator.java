package lotto.common;

import java.text.DecimalFormat;

public class Calculator {

	public static final double ROUNDS = 100.0;

	public static double profitRate(double initial, double review) {
		double profitRate = review / initial;
		return Math.round(profitRate * ROUNDS) / ROUNDS;
	}
}
