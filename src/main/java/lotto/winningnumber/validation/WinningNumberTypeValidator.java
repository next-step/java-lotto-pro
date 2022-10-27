package lotto.winningnumber.validation;

import java.util.List;
import java.util.regex.Pattern;

public class WinningNumberTypeValidator implements WinningNumberValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            isNotNumberThenThrow(winningNumber);
        }
    }

    private void isNotNumberThenThrow(String winningNumber) {
        if (!NUMBER_PATTERN.matcher(winningNumber).matches()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_TYPE_MESSAGE);
        }
    }
}
