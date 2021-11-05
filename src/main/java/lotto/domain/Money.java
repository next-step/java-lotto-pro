package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import lotto.utils.MessageBuilder;

public class Money {
	private static final int MONEY_MIN = 0;

	private final int money;

	private Money(int money) {
		this.money = money;
	}

	public static Money of(int money) {
		validateMoney(money);
		return new Money(money);
	}

	private static void validateMoney(int money) {
		if (isValidMoney(money)) {
			return;
		}

		throw new IllegalArgumentException(MessageBuilder.build(INVALID_INPUT_MONEY, money));
	}

	private static boolean isValidMoney(int money) {
		return money >= MONEY_MIN;
	}

	public int getValue() {
		return this.money;
	}
}
