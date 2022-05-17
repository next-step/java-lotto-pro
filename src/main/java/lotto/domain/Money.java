package lotto.domain;

public class Money {
	private final String INVALID_NUMBER = "0 이상의 수를 입력해주세요.";
	private final int LOTTO_PRICE = 1000;
	private final int ZERO = 0;

	private int money;

	public Money(int money) {
		validatePositiveNumber(money);
		this.money = money;
	}

	public int availableQuantity() {
		return money / LOTTO_PRICE;
	}

	public int expenses() {
		return availableQuantity() * LOTTO_PRICE;
	}

	private void validatePositiveNumber(int money) {
		if(money < ZERO) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}
}
