package lotto.domain.validation;

import java.util.Set;

public class RangeValidator implements NumberValidator {

    private static final String ERROR_RANGE_MESSAGE = "[ERROR] 번호에 1 ~ 45 사이의 숫자가 아닌 값이 포함되어 있습니다.";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    @Override
    public void validate(Set<String> numbers) {
        for (String number : numbers) {
            isOverRangeThenThrow(number.trim());
        }
    }

    private void isOverRangeThenThrow(String number) {
        int parseNumber = Integer.parseInt(number);
        if (parseNumber < MIN_RANGE || parseNumber > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE);
        }
    }
}
