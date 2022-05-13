package calculator;

import java.util.Arrays;
import java.util.HashSet;

public class StringCalculator {
    private static final HashSet<String> ZERO_CONDITIONS = new HashSet<>(Arrays.asList("", null));
    private static final String NUMBER_TYPE_REGEX = "^[0-9]*$";

    public int sum(String input) {
        if (ZERO_CONDITIONS.contains(input)) {
            return 0;
        }

        validate(input);
        return 0;
    }

    private void validate(String input) {
        validateNumberType(input);
    }

    private void validateNumberType(String input) {
        if (!input.matches(NUMBER_TYPE_REGEX)) {
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
    }
}
