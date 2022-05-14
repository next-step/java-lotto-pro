package calculator;

import calculator.utils.Splitter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final HashSet<String> ZERO_CONDITIONS = new HashSet<>(Arrays.asList("", null));
    private static final String NUMBER_TYPE_REGEX = "^[0-9]*$";

    public int sum(String input) {
        if (ZERO_CONDITIONS.contains(input)) {
            return 0;
        }

        String[] splitStrings = splitInput(input);
        validate(splitStrings);

        return IntStream.of(stringArrayToIntArray(splitStrings)).sum();
    }

    private String[] splitInput(String input) {
        return Splitter.splitString(input);
    }

    private int[] stringArrayToIntArray(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }

    private void validate(String[] inputStrings) {
        for (String input : inputStrings) {
            validateNumberType(input);
        }
    }

    private void validateNumberType(String input) {
        if (!input.matches(NUMBER_TYPE_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
