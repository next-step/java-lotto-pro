package lotto.domain.validator.impl;

import java.util.regex.Pattern;
import lotto.exception.ExceptionType;
import lotto.domain.validator.LottoNumbersValidator;

public class DefaultFormatLottoNumbersValidator implements LottoNumbersValidator {

    private static final Pattern DEFAULT_REGEX = Pattern.compile("^(((\\d{1,2})(\\,))+\\d{1,2}$)");

    @Override
    public void validate(String winningNumbers) {
        if (!DEFAULT_REGEX.matcher(winningNumbers).matches()) {
            throw new IllegalArgumentException(
                ExceptionType.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }
}
