package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
	private static final String ERROR_WINNING_NUMBER_TYPE = "당첨 번호는 (, )를 구분자로 숫자만 입력 가능합니다. \n[예시] 1, 2, 3, 4, 5, 6";
	private static final int MIN_REQUIRED_NUMBER = 6;
	private final List<Integer> winningNumbers = new ArrayList<>();

	public WinningNumbers(String winningNumbers) {
		String[] stringNumberArray = winningNumbers.split(", ");
		validateWinningNumbers(stringNumberArray);
		for (String stringNumber : stringNumberArray) {
			this.winningNumbers.add(stringValueToIntValue(stringNumber));
		}
	}

	private void validateWinningNumbers(String[] stringNumberArray) {
		if (stringNumberArray.length < MIN_REQUIRED_NUMBER) {
			throw new IllegalArgumentException(ERROR_WINNING_NUMBER_TYPE);
		}
	}

	private int stringValueToIntValue(String stringNumber) {
		try {
			return Integer.parseInt(stringNumber);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_WINNING_NUMBER_TYPE);
		}
	}
}

