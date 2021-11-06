package step3;

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

	public int yield(int sumAmount) {
		return Math.floorDiv(sumAmount, this.money);
	}

	@Override
	public String toString() {
		return String.valueOf(money);
	}

}
