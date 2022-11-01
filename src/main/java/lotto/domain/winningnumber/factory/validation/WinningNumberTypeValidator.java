package lotto.domain.winningnumber.factory.validation;

import java.util.Set;
import java.util.regex.Pattern;

public class WinningNumberTypeValidator implements WinningNumberValidator {

    private static final String ERROR_WINNING_NUMBER_TYPE_MESSAGE = "[ERROR] 당첨 번호에 숫자가 아닌 값이 포함되어 있습니다.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(Set<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            isNotNumberThenThrow(winningNumber.trim());
        }
    }

    private void isNotNumberThenThrow(String winningNumber) {
        if (!NUMBER_PATTERN.matcher(winningNumber).matches()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_TYPE_MESSAGE);
        }
    }
}
