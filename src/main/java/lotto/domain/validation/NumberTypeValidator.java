package lotto.domain.validation;

import java.util.Set;
import java.util.regex.Pattern;

public class NumberTypeValidator implements NumberValidator {

    private static final String ERROR_NUMBER_TYPE_MESSAGE = "[ERROR] 번호에 숫자가 아닌 값이 포함되어 있습니다.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(Set<String> numbers) {
        for (String number : numbers) {
            isNotNumberThenThrow(number.trim());
        }
    }

    private void isNotNumberThenThrow(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE_MESSAGE);
        }
    }
}
