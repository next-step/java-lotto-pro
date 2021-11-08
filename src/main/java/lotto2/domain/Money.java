package lotto2.domain;

public class Money {

	private final int money;

	private Money(int money) {
		this.money = money;
	}

	public static Money of(int inputMoney) {
		validateMoney(inputMoney);
		return new Money(inputMoney);
	}

	public static void validateMoney(int inputMoney) {
		if (inputMoney < 0) {
			throw new IllegalArgumentException(ErrorMessage.MONEY_ONLY_POSITIVE_NUMBER.value());
		}
	}

	public int toInt() {
		return this.money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Money money1 = (Money)o;

		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return money;
	}

}
