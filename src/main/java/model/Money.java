package model;

public class Money {
	private static final String NUMBER_REGEX = "^[0-9]+$";

	private int value;

	private Money(int value) {
		this.value = value;
	}

	public static boolean validate(String moneyString) {
		return moneyString.matches(NUMBER_REGEX);
	}

	public static Money of(String moneyString) {
		try {
			return new Money(Integer.parseInt(moneyString));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력해야 합니다.");
		}
	}

	public int getValue() {
		return value;
	}

}
