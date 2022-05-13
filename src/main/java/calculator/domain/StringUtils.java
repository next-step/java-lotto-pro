package calculator.domain;

import java.util.Arrays;

public class StringUtils {
    private static final String MSG_NOT_NUMBER = "숫자 이외의 값을 입력으로 받을 수 없습니다.";
    private static final String MSG_NEGATIVE = "음수를 입력으로 받을 수 없습니다";

    private StringUtils() {
    }

    public static int[] toPositiveNumbers(String[] inputs) {
        return Arrays.asList(inputs).stream()
                .map(input -> validateAndReturn(input))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String validateAndReturn(String input) {
        validatePositiveNumber(input);
        return input;
    }

    private static void validatePositiveNumber(String input) {
        if (!input.matches("\\p{Digit}")) {
            throw new RuntimeException(MSG_NOT_NUMBER);
        }
        if (Integer.parseInt(input) < 0) {
            throw new RuntimeException(MSG_NEGATIVE);
        }
    }
}
