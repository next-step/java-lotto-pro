package lotto;

import lotto.common.Messages;

public class BonusBall {
	private LottoNumber bonusBall;

	public BonusBall(String input) {
		this.bonusBall = new LottoNumber(validate(input));
	}

	private Integer validate(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
		}
	}

	public LottoNumber getBonusBall() {
		return bonusBall;
	}
}
