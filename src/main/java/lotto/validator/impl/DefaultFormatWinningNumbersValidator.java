package lotto.validator.impl;

import java.util.regex.Pattern;
import lotto.exception.ExceptionType;
import lotto.validator.WinningNumbersValidator;

public class DefaultFormatWinningNumbersValidator implements WinningNumbersValidator {

    private static final Pattern DEFAULT_REGEX = Pattern.compile("^(((\\d{1,2})(\\,))+\\d{1,2}$)");

    @Override
    public void validate(String winningNumbers) {
        if (!DEFAULT_REGEX.matcher(winningNumbers).matches()) {
            throw new IllegalArgumentException(
                ExceptionType.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }
}
