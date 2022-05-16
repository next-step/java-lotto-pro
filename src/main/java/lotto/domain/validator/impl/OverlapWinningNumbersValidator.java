package lotto.domain.validator.impl;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionType;
import lotto.domain.validator.WinningNumbersValidator;

public class OverlapWinningNumbersValidator implements WinningNumbersValidator {

    @Override
    public void validate(String winningNumbers) {
        List<String> numbers = Arrays.asList(winningNumbers.split(SPLIT_SYMBOL));
        Set<String> target = new HashSet<>(numbers);

        if (numbers.size() != target.size()) {
            throw new IllegalArgumentException(
                ExceptionType.IS_NOT_OVERLAP_WINNING_NUMBER.getMessage());
        }
    }
}
