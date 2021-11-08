package step3.winner;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WinningMoney {

	private static final int TWO_DIGITS = 2;
	private static final String WINNING_SUM_NOT_DIGIT = "상금 합계가 정수가 아닙니다.";


	public BigDecimal yield(BigDecimal money, int sumAmount) {
		if (Character.isDigit(sumAmount)) {
			throw new IllegalArgumentException(WINNING_SUM_NOT_DIGIT);
		}
		return new BigDecimal(String.valueOf(sumAmount)).divide(money, TWO_DIGITS, RoundingMode.FLOOR);
	}
}
