package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdderCalculator {

    private static final String DEFAULT_DELIMITERS = ",";

    public static int splitAndSum(String text) {
        if (isTextEmptyOrNull(text)) {
            return 0;
        }
        List<String> numbersLiteral = split(text);
        List<Integer> parsedNumbers = parseInteger(numbersLiteral);

        return sumAll(parsedNumbers);
    }

    private static int sumAll(List<Integer> parsedNumbers) {
        return parsedNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> parseInteger(List<String> numbersLiteral) {
        return numbersLiteral.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> split(String text) {
        return toArray(text.split(DEFAULT_DELIMITERS));
    }

    private static List<String> toArray(String... splitNumbers) {
        return Arrays.asList(splitNumbers);
    }

    private static boolean isTextEmptyOrNull(String strings) {
        return strings == null || strings.trim().isEmpty();
    }
}
