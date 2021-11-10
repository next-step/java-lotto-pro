package step3;

public class Money {
	private final int money;
	private final int DEFAULT_MONEY = 1000;
	private int size;

	public Money(int money) {
		validation(money);
		this.money = money;
		this.size = Math.floorDiv(money, DEFAULT_MONEY);
	}

	public Money(String input) {
		this(Integer.parseInt(input));
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
		return size;
	}

	@Override
	public String toString() {
		return String.valueOf(money);
	}
}
