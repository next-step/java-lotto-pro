package step3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
	private final int money;
	private final int DEFAULT_MONEY = 1000;

	public Money(int money) {
		validation(money);
		this.money = money;
	}

	private void validation(int money) {
		if (isDefaultMoneyLessThen(money)) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
	}

	private boolean isDefaultMoneyLessThen(int money) {
		return money < DEFAULT_MONEY;
	}

	public int buyCount() {
		return Math.floorDiv(money, DEFAULT_MONEY);
	}

	public BigDecimal yield(int sumAmount) {
		return new BigDecimal(sumAmount).divide(new BigDecimal(this.money), 2, RoundingMode.FLOOR);
	}

	@Override
	public String toString() {
		return String.valueOf(money);
	}

}
