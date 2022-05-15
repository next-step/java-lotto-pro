package lotto.domain;

public class Money {
	private final String INVALID_NUMBER = "0 이상의 수를 입력해주세요.";
	private final int ZERO = 0;

	private int money;

	public Money(int money) {
		validPositiveNumber(money);
	}

	private void validPositiveNumber(int money) {
		if(money < ZERO) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}
}
