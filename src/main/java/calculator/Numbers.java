package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    private static final String BASE_SEPARATOR = "[,:]";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int SEPARATOR_GROUP = 1;
    private static final int NUMBERS_GROUP = 2;
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Numbers from(String string) {
        if (string == null || string.isEmpty()) {
            return new Numbers(Collections.emptyList());
        }
        List<Number> numbers = split(string);
        return new Numbers(numbers);
    }

    private static List<Number> split(String string) {
        String[] numbers = splitByCustomSeparator(string).orElse(string.split(BASE_SEPARATOR));
        return Arrays.stream(numbers)
                .map(Number::from)
                .collect(Collectors.toList());
    }

    private static Optional<String[]> splitByCustomSeparator(String string) {
        Matcher customMatcher = CUSTOM_SEPARATOR_PATTERN.matcher(string);
        if (customMatcher.find()) {
            String separator = customMatcher.group(SEPARATOR_GROUP);
            String numbers = customMatcher.group(NUMBERS_GROUP);
            return Optional.of(numbers.split(separator));
        }
        return Optional.empty();
    }

    public Number sum() {
        return numbers.stream()
                .reduce(Number::add)
                .orElse(Number.ZERO);
    }
}
