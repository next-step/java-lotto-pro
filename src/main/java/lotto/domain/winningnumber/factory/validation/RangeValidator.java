package lotto.domain.winningnumber.factory.validation;

import java.util.Set;

public class RangeValidator implements WinningNumberValidator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    @Override
    public void validate(Set<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            isOverRangeThenThrow(winningNumber.trim());
        }
    }

    private void isOverRangeThenThrow(String winningNumber) {
        int parseWinningNumber = Integer.parseInt(winningNumber);
        if (parseWinningNumber < MIN_RANGE || parseWinningNumber > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE);
        }
    }
}
