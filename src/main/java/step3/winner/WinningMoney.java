package step3.winner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import step3.Money;

public class WinningMoney {

	private static final int TWO_DIGITS = 2;
	private static final String WINNING_SUM_NOT_DIGIT = "상금 합계가 정수가 아닙니다.";
	private BigDecimal money;
	private BigDecimal yieldMoney;


	public WinningMoney(Money money) {
		this.money = new BigDecimal(String.valueOf(money));
		this.yieldMoney = BigDecimal.ZERO;
	}

	public BigDecimal yield(int sumAmount) {
		if (Character.isDigit(sumAmount)) {
			throw new IllegalArgumentException(WINNING_SUM_NOT_DIGIT);
		}
		yieldMoney = new BigDecimal(String.valueOf(sumAmount)).divide(money, TWO_DIGITS, RoundingMode.FLOOR);
		return yieldMoney;
	}
}
