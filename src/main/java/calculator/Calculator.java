package calculator;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern STRING_REGEX = Pattern.compile("((//)\\D(\\\\n))|[:,]");
    private static final Pattern NUMBER_REGEX = Pattern.compile("[1-9]");

    public Number sum(String input) {
        if (input == null || isBlank(input)) {
            return Number.ZERO();
        }
        return sum(parseNumber(split(input)));
    }

    private boolean isBlank(String input) {
        return input.trim().isEmpty();
    }

    private Number sum(List<Number> numbers) {
        return numbers.stream()
                .reduce(new Number(0), Number::sum);
    }

    private List<String> split(String input) {
        return Arrays.stream(STRING_REGEX.split(input))
                .map(String::trim)
                .collect(toList());
    }

    private List<Number> parseNumber(List<String> numbers) {
        validation(numbers);

        return numbers.stream()
                .map(Integer::new)
                .map(Number::new)
                .collect(toList());
    }

    private void validation(List<String> nums) {
        long count = nums.stream()
                .filter(num -> !NUMBER_REGEX.matcher(num).matches())
                .count();

        if (count > 0) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
