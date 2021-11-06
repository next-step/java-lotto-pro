package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
	private final List<Integer> winningNumbers = new ArrayList<>();

	public WinningNumbers(String winningNumbers) {
		String[] stringNumberArray = winningNumbers.split(CommonConstant.DELIMITER);
		validateWinningNumbers(stringNumberArray);
		for (String stringNumber : stringNumberArray) {
			this.winningNumbers.add(stringValueToIntValue(stringNumber));
		}
	}

	private void validateWinningNumbers(String[] stringNumberArray) {
		if (stringNumberArray.length < CommonConstant.MIN_REQUIRED_NUMBER_LOTTO) {
			throw new IllegalArgumentException(CommonMessage.ERROR_WINNING_NUMBER_TYPE);
		}
	}

	private int stringValueToIntValue(String stringNumber) {
		try {
			return Integer.parseInt(stringNumber);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(CommonMessage.ERROR_WINNING_NUMBER_TYPE);
		}
	}

	public List<Integer> value() {
		return winningNumbers;
	}
}

