package lotto.domain;

public class LottoProfit {

	public static double calculate(int totalPrizeMoney, int money) {
		double result = (double)totalPrizeMoney / money;
		return Math.floor(result * 100) / 100D;
	}

}
