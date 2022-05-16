package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringToNumbersConverter {
    private static final Pattern INVALID_LOTTO_NUMBERS_STRING_PATTERN = Pattern.compile("[^-\\,0-9\\s]");
    private static final String SEPARATOR = ",";

    public static List<Integer> convert(final String numbersString) {
        validate(numbersString);
        final List<Integer> numbers = new ArrayList<>();
        for (final String number : numbersString.replaceAll("\\s", "").split(SEPARATOR)) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static void validate(final String numbersString) {
        if (INVALID_LOTTO_NUMBERS_STRING_PATTERN.matcher(numbersString).find()) {
            throw new IllegalArgumentException();
        }
    }
}
