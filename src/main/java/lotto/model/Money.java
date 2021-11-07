package lotto.model;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;

public class Money {
	private static final String NUMBER_REGEX = "[0-9]+";

	private final String inputMoney;

	public Money(String inputMoney) {
		validNullOrEmpty(inputMoney);
		validNumber(inputMoney);
		validUnderLottoPrice(inputMoney);
		this.inputMoney = inputMoney;
	}

	private void validNullOrEmpty(String input) {
		if (isNullOrEmpty(input)) {
			throw new LottoException(ErrorCode.INVALID_INPUT_NULL_VALUE_ERROR);
		}
	}

	private void validNumber(String input) {
		if (isNumber(input)) {
			throw new LottoException(ErrorCode.INVALID_INPUT_NUMBER_ERROR);
		}
	}

	private boolean isNumber(String input) {
		return !input.matches(NUMBER_REGEX);
	}

	private boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private void validUnderLottoPrice(String input) {
		if (isUnderLottoPrice(input)) {
			throw new LottoException(ErrorCode.UNDER_LOTTO_PRICE_ERROR);
		}
	}

	private boolean isUnderLottoPrice(String input) {
		return Integer.parseInt(input) < LottoGenerator.LOTTO_PRICE;
	}

	public String money() {
		return inputMoney;
	}

	public int moneyToInt() {
		return Integer.parseInt(inputMoney);
	}
}