package lotto.domain.validator.impl;

import static lotto.constants.LottoConstants.MAX;
import static lotto.constants.LottoConstants.MIN;
import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.WinningNumbersValidator;
import lotto.exception.ExceptionType;

public class InvalidWinningNumberSizeValidator implements WinningNumbersValidator {

    @Override
    public void validate(String winningNumbers) {
        List<String> list = Arrays.asList(winningNumbers.split(SPLIT_SYMBOL));
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
