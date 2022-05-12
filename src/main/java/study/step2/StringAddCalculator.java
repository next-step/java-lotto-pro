package study.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import study.step2.exception.NumberConversionException;

public class StringAddCalculator {
    private static final int ZERO = 0;

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private static final String NEGATIVE_INTEGER_EXCEPTION = "양수만 계산 가능합니다.";
    private static final String NON_INTEGER_EXCEPTION = "%s 는 숫자가 아닙니다.";

    private StringAddCalculator() {
        throw new IllegalStateException("StringAddCalculator class");
    }

    public static int splitAndSum(String numberString) {
        if (isNullOrEmptyString(numberString)) {
            return ZERO;
        }

        List<String> numberByCustomDelimiter = splitByCustomDelimiter(numberString);
        return numberByCustomDelimiter.isEmpty() ? add(splitNumberString(numberString, DEFAULT_DELIMITERS))
                : add(numberByCustomDelimiter);
    }

    private static List<String> splitByCustomDelimiter(String numberString) {
        Matcher matcher = getMatcher(CUSTOM_DELIMITER_PATTERN, numberString);
        return matcher.find() ? splitNumberString(matcher.group(2), matcher.group(1)) : new ArrayList<>();
    }

    private static Matcher getMatcher(String pattern, String text) {
        return Pattern.compile(pattern).matcher(text);
    }

    private static List<String> splitNumberString(String numberString, String delimiter) {
        return Arrays.asList(numberString.split(delimiter));
    }

    private static boolean isNullOrEmptyString(String numbers) {
        return Objects.isNull(numbers) || numbers.isEmpty();
    }

    private static int add(List<String> numberList) {
        return numberList.stream()
                .map(StringAddCalculator::toPositiveInteger)
                .reduce(ZERO, (num1, num2) -> num1 + num2);
    }

    private static Integer toPositiveInteger(String number) {
        Integer integer = toInteger(number);
        if (integer < ZERO) {
            throw new NumberConversionException(NEGATIVE_INTEGER_EXCEPTION);
        }

        return integer;
    }

    private static Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new NumberConversionException(String.format(NON_INTEGER_EXCEPTION, number));
        }
    }
}


