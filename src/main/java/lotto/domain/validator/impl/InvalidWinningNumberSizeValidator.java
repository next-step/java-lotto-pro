package lotto.domain.validator.impl;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.WinningNumbersValidator;
import lotto.exception.ExceptionType;
import lotto.utils.LottoUtils;

public class InvalidWinningNumberSizeValidator implements WinningNumbersValidator {

    @Override
    public void validate(String winningNumbers) {
        List<String> list = Arrays.asList(winningNumbers.split(SPLIT_SYMBOL));
        long invalidNumberCount = list.stream()
            .filter(number -> LottoUtils.isLottoNumberSize(Integer.parseInt(number)))
            .count();

        if (invalidNumberCount > 0) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
        }
    }
}
