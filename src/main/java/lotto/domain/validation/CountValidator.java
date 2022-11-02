package lotto.domain.validation;

import java.util.Set;

public class CountValidator implements NumberValidator {

    private static final String ERROR_COUNT_MESSAGE = "[ERROR] 번호의 갯수를 다시 확인해주세요.";
    private static final int NUMBER_COUNT = 6;

    @Override
    public void validate(Set<String> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_COUNT_MESSAGE);
        }
    }
}
