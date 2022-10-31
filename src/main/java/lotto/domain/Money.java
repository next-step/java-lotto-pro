package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class Money {

	private static final String INVALID_INPUT_MONEY_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";
	private static final String INVALID_TICKET_PRICE_MESSAGE = "티켓 가격이 0원 일 수 없습니다.";
	private static final String DIVEIDE_BY_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";
	protected static final int PRICE_PER_TICKET = 1000;

	private final long value;

	private Money(long value) {
		validate(value);
		this.value = value;
	}

	public static Money from(int value) {
		return new Money(value);
	}

	public static Money from(long value) {
		return new Money( value);
	}

	private static void validate(long value) {
		if (value < 0) {
			throw new InvalidMoneyException("금액은 음수일 수 없습니다.");
		}
	}

	public long getValue() {
		return value;
	}

	public TicketCount ticketCount(Money ticketPrice) {
		if (this.value < PRICE_PER_TICKET) {
			throw new InvalidMoneyException(INVALID_INPUT_MONEY_MESSAGE);
		}
		try {
			return TicketCount.from((int) (this.value / ticketPrice.getValue()));
		} catch (ArithmeticException e) {
			throw new InvalidMoneyException(INVALID_TICKET_PRICE_MESSAGE);
		}
	}

	public double divide(Money money) {
		if (money.value == 0) {
			throw new InvalidMoneyException(DIVEIDE_BY_ZERO_MESSAGE);
		}
		return (double)this.value / money.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Money money = (Money)o;

		return value == money.value;
	}

	@Override
	public int hashCode() {
		return (int)(value ^ (value >>> 32));
	}
}
