package lotto;

import java.util.List;

import lotto.common.Messages;

public class BonusBall {
	private LottoNumber bonusBall;

	public BonusBall(String input) {
		this.bonusBall = new LottoNumber(parseNumber(input));
	}

	public BonusBall(String input, WinnerNumber winnerNumber) {
		this.bonusBall = new LottoNumber(parseNumber(input));
		validate(winnerNumber);
	}

	private void validate(WinnerNumber winnerNumber) {
		if (winnerNumber.getWinnerNumber().getLottoNumbers().contains(this.bonusBall)) {
			throw new IllegalArgumentException(Messages.INPUT_BONUS_BALL_NOT_VALID.getValues());
		}
	}

	private Integer parseNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
		}
	}

	public LottoNumber getBonusBall() {
		return bonusBall;
	}

	public boolean match(List<LottoNumber> numbers) {
		return numbers.contains(this.bonusBall);
	}
}
