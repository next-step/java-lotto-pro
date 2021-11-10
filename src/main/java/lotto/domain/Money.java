package lotto.domain;

import java.util.Objects;

import lotto.domain.exception.IllegalMoneyException;
import lotto.domain.exception.OverSpendingMoneyException;

public class Money {

	private int amount;

	public Money(final int amount) {
		validateMoneyExist(amount);
		this.amount = amount;
	}

	public void spend(int payment) {
		validateNotOverSpending(payment);

		amount -= payment;
	}

	public int amount() {
		return amount;
	}

	private void validateMoneyExist(int amount) {
		if (amount < 0) {
			throw new IllegalMoneyException();
		}
	}

	private void validateNotOverSpending(int payment) {
		if (payment > amount) {
			throw new OverSpendingMoneyException();
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
