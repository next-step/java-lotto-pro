package lotto;

import static lotto.common.Constants.*;

import lotto.common.Messages;

public class Investment {
	private Integer investment;

	public Investment(String input) {
		validate(input);
		this.investment = Integer.parseInt(input);
	}

	/**
	 * 1000 이상의 숫자만 가능
	 * 1000으로 나누어 떨어져야 함
	 *
	 * @param input
	 */
	public void validate(String input) {
		if (!NUMBER_PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
		}
		Integer integerInput = Integer.parseInt(input);
		if (integerInput < PER_PRICE) {
			throw new IllegalArgumentException(Messages.INPUT_INVESTMENT_MIN_VALID.getValues());
		}
		if (Math.floorMod(integerInput, PER_PRICE) != 0) {
			throw new IllegalArgumentException(Messages.INPUT_INVESTMENT_UNIT_VALID.getValues());
		}
	}

	public Integer getInvestment() {
		return investment;
	}

	public Integer getCount() {
		return Math.floorDiv(this.investment, PER_PRICE);
	}
}
