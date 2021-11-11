package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;

public class Money {
	public static final Money LOTTO_PRICE = Money.from(new BigDecimal(1000));
	private static final int MATH_ROUND_VALUE = 1;
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
		return LOTTO_PRICE.money.compareTo(new BigDecimal(input)) > 0;
	}

	public static Money from(BigDecimal input) {
		return new Money(input);
	}

	public int calculateLottoAmount() {
		return money.divide(LOTTO_PRICE.money).intValue();
	}

	public int getMoney() {
		return money.intValue();
	}

	public BigDecimal calculateYield(Money sum) {
		return sum.money.divide(money, MATH_ROUND_VALUE, RoundingMode.HALF_EVEN);
	}

	public boolean validSizeUnderAmount(int inputSize) {
		return calculateLottoAmount() < inputSize;
	}

	public Money calculatePurchaseMoney(BigDecimal size) {
		return Money.from(LOTTO_PRICE.money.multiply(size));
	}

	public Money sumMoney(Money inputMoney) {
		return Money.from(money.add(inputMoney.money));
	}

	public Money calculateRankMoney(BigDecimal size) {
		return Money.from(money.multiply(size));
	}
}