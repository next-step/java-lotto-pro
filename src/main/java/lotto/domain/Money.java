package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class Money {

	private static final String INVALID_INPUT_MONEY_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";
	private static final String INVALID_TICKET_PRICE_MESSAGE = "티켓 가격이 0원 일 수 없습니다.";

	private final int value;

	private Money(int value) {
		this.value = value;
	}

	public static Money of(int value) {
		validate(value);
		return new Money(value);
	}

	private static void validate(int value) {
		if (value < 0) {
			throw new InvalidMoneyException("금액은 음수일 수 없습니다.");
		}
	}

	public int getValue() {
		return value;
	}

	public TicketCount ticketCount(Money ticketPrice) {
		if (this.value < 1000) {
			throw new InvalidMoneyException(INVALID_INPUT_MONEY_MESSAGE);
		}
		try {
			return TicketCount.of(this.value / ticketPrice.getValue());
		} catch (ArithmeticException e) {
			throw new InvalidMoneyException(INVALID_TICKET_PRICE_MESSAGE);
		}
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
		return value;
	}

}
