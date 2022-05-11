package calculator.add.string.utils;

public class StringInputValidator {

    private static final String POSITIVE_INTEGER_TYPE_REGEX = "\\d+";

    public static void validateIsPositiveInteger(String input) {
        if (!input.matches(POSITIVE_INTEGER_TYPE_REGEX)) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }

    public static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

}
