package lotto.domain;

public class Number {
	private final String INVALID_VALUE = "1~45 사이의 숫자만 입력 가능합니다.";
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 1;

	private int number;

	public Number(int number) {
		validNumber(number);
		this.number = number;
	}

	private void validNumber(int number) {
		if(number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(INVALID_VALUE);
		}
	}
}
