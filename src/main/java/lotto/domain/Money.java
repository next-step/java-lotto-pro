package lotto.domain;

import java.util.Objects;

public class Money {
	public static final String NO_MONEY_ERROR = "구입 자금은 0원 보다 작을 수 없습니다.";
	public static final String OVERSPENDING_ERROR = "보유한 자금보다 더 많이 사용 할 수 없습니다.";

	private final int amount;

	public Money(final int amount) {
		validateMoneyExist(amount);
		this.amount = amount;
	}

	public Money spend(int payment) {
		validateNotOverSpending(payment);

		return new Money(amount - payment);
	}

	public int amount() {
		return amount;
	}

	private void validateMoneyExist(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(NO_MONEY_ERROR);
		}
	}

	private void validateNotOverSpending(int payment) {
		if (payment > amount) {
			throw new IllegalArgumentException(OVERSPENDING_ERROR);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return amount == money.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public String toString() {
		return "Money{" +
			"amount=" + amount +
			'}';
	}
}
