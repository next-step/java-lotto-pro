package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;

public class Money {
	public static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);
	private static final int MATH_ROUND_VALUE = 2;
	private static final String NUMBER_REGEX = "[0-9]+";
	private final BigDecimal money;

	private Money(BigDecimal money) {
		this.money = money;
	}

	public static Money from(String inputMoney) {
		validNullOrEmpty(inputMoney);
		validNumber(inputMoney);
		validUnderLottoPrice(inputMoney);
		return new Money(new BigDecimal(inputMoney));
	}

	public static Money from(int inputMoney) {
		return new Money(new BigDecimal(inputMoney));
	}

	private static void validNullOrEmpty(String input) {
		if (isNullOrEmpty(input)) {
			throw new LottoException(ErrorCode.INVALID_INPUT_NULL_VALUE_ERROR);
		}
	}

	private static void validNumber(String input) {
		if (isNumber(input)) {
			throw new LottoException(ErrorCode.INVALID_INPUT_NUMBER_ERROR);
		}
	}

	private static boolean isNumber(String input) {
		return !input.matches(NUMBER_REGEX);
	}

	private static boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private static void validUnderLottoPrice(String input) {
		if (isUnderLottoPrice(input)) {
			throw new LottoException(ErrorCode.UNDER_LOTTO_PRICE_ERROR);
		}
	}

	private static boolean isUnderLottoPrice(String input) {
		return Integer.parseInt(input) < LOTTO_PRICE.intValue();
	}

	public int calculateLottoAmount() {
		return money.divide(LOTTO_PRICE).intValue();
	}

	public int getMoney() {
		return money.intValue();
	}

	public float calculateYield(BigDecimal sum) {
		return sum.divide(money, MATH_ROUND_VALUE, RoundingMode.HALF_EVEN).floatValue();
	}
}