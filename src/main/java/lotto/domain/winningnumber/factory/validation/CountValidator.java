package lotto.domain.winningnumber.factory.validation;

import java.util.Set;

public class CountValidator implements WinningNumberValidator {

    private static final String ERROR_COUNT_MESSAGE = "[ERROR] 당첨 번호의 갯수를 다시 확인해주세요.";
    private static final int WINNING_NUMBER_COUNT = 6;

    @Override
    public void validate(Set<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_COUNT_MESSAGE);
        }
    }
}
