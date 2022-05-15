package lotto.validator.impl;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.exception.ExceptionType;
import lotto.validator.WinningNumbersValidator;

public class InvalidWinningNumberSizeValidator implements WinningNumbersValidator {

    private static final int MAX = 45;
    private static final int MIN = 1;

    @Override
    public void validate(String winningNumbers) {
        List<String> list = Arrays.asList(winningNumbers.split(WinningNumbers.SPLIT_SYMBOL));
        long invalidNumberCount = list.stream().filter(x -> isLottoNumberSize(Integer.parseInt(x)))
            .count();

        if (invalidNumberCount > 0) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private boolean isLottoNumberSize(int number) {
        return number > MAX || number < MIN;
    }
}
