package lotto.domain.winningnumber.validation;

import java.util.Set;

public class CountValidator implements WinningNumberValidator {

    private static final int WINNING_NUMBER_COUNT = 6;

    @Override
    public void validate(Set<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_COUNT_MESSAGE);
        }
    }
}
