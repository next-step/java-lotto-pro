package utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdderCalculator {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {
        if (isTextEmptyOrNull(text)) {
            return 0;
        }
        if (isCustomDelimiter(text)) {
            return splitAndSumWithCustomDelimiter(text);
        }
        List<String> numbersLiteral = split(text, DEFAULT_DELIMITERS);
        List<Integer> parsedNumbers = parseInteger(numbersLiteral);

        return sumAll(parsedNumbers);
    }

    private static int splitAndSumWithCustomDelimiter(String text) {
        Matcher matchers = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (!matchers.find()) {
            throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다");
        }
        String customDelimiter = matchers.group(1);
        List<String> numbersLiteral = split(matchers.group(2), customDelimiter);
        return sumAll(parseInteger(numbersLiteral));
    }

    private static boolean isCustomDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
    }

    private static int sumAll(List<Integer> parsedNumbers) {
        return parsedNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> parseInteger(List<String> numbersLiteral) {
        return numbersLiteral.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> split(String text, String delimiter) {
        return toArray(text.split(delimiter));
    }

    private static List<String> toArray(String... splitNumbers) {
        return Arrays.asList(splitNumbers);
    }

    private static boolean isTextEmptyOrNull(String strings) {
        return strings == null || strings.trim().isEmpty();
    }
}
