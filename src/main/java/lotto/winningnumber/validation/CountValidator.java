package lotto.winningnumber.validation;

import java.util.List;

public class CountValidator implements WinningNumberValidator {

    private static final int WINNING_NUMBER_COUNT = 6;

    @Override
    public void validate(List<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_COUNT_MESSAGE);
        }
    }
}
