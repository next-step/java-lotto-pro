package calculator;

import calculator.exception.InvalidNumberException;
import java.util.Arrays;

public class StringAddCalculator {

    private static final int DEFAULT_RETURN = 0;
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";

    private StringAddCalculator() {
        throw new IllegalStateException("Utility Class");
    }

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return DEFAULT_RETURN;
        }

        String[] splitNumbers = StringSplitter.split(input);
        validatePositiveNumbers(splitNumbers);
        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).sum();
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static void validatePositiveNumbers(String[] numbers) {
        boolean isPositiveNumber = Arrays.stream(numbers).allMatch(number -> number.matches(POSITIVE_NUMBER_REGEX));
        if (!isPositiveNumber) {
            throw new InvalidNumberException(MessageConstant.INVALID_NUMBER);
        }
    }

}
