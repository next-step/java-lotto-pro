package study;

public class StringAddCalculator {

    public static final String ONLY_NUMBER_REGEX = "^[0-9]";
    public static final int DEFAULT_RETURN_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmptyString(input)) {
            return DEFAULT_RETURN_VALUE;
        }
        String[] numbers = StringInputParser.toStringArray(input);
        validatePositiveNumbers(numbers);

        return calculate(numbers);
    }
    private static void validatePositiveNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private static void validateNumber(String number) {
        if (!number.matches(ONLY_NUMBER_REGEX)) {
            throw new RuntimeException("0부터 9까지의 숫자만 허용합니다.");
        }
    }

    private static int calculate(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += StringInputParser.toInt(number);
        }
        return sum;
    }

    private static boolean isNullOrEmptyString(String input) {
        return input == null || input.isEmpty();
    }
}
