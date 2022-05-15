package lotto.domain;

public class Money {
	private final String INVALID_NUMBER = "0 이상의 수를 입력해주세요.";
	private final String EMPTY_VALUE = "빈값을 입력할 수 없습니다.";
	private final int ZERO = 0;

	private int money;

	public Money(String money) {
		validEmpty(money);
	}

	public Money(int money) {
		validPositiveNumber(money);
		this.money = money;
	}

	private void validEmpty(String money) {
		if(money == null || money.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_VALUE);
		}
	}

	private void validPositiveNumber(int money) {
		if(money < ZERO) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}
}
