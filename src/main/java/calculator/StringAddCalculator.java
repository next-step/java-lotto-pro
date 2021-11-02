package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "입력 값이 음수이거나 숫자가 아닙니다.";
    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final Pattern DUAL_NUMBER_PATTERN = Pattern.compile(IS_NUMBER_REGEX);

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] splitInputs = Separator.split(input);
        List<Integer> numbers = parseNumber(splitInputs);

        validateNumbers(splitInputs);

        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static List<Integer> parseNumber(String[] splitInputs) {
        return Arrays.stream(splitInputs)
                .map(input -> Integer.parseInt(input))
                .collect(Collectors.toList());
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private static void validateNumbers(String[] splitInputs) {
        Arrays.stream(splitInputs).forEach(
                number -> {
                    if (!DUAL_NUMBER_PATTERN.matcher(number).matches()) {
                        throw new RuntimeException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
                    }
                }
        );
    }

}
