package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final Pattern customSplitPattern = Pattern.compile("//(.)\n(.*)");
    private static final int ZERO = 0;
    private static final String DEFAULT_REGEX = ",|:";

    public static int splitAndSum(String s) {
        if (isBlank(s)) {
            return ZERO;
        }

        Matcher m = customSplitPattern.matcher(s);
        if (m.find()) {
            return sum(split(m.group(2), m.group(1)));
        }

        return sum(split(s, DEFAULT_REGEX));
    }

    private static boolean isBlank(String s) {
        return s == null || s.isEmpty();
    }

    private static String[] split(String str, String regex) {
        return str.split(regex);
    }

    private static int sum(String[] numbers) {
        return sum(toInts(numbers));
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values).map(StringAddCalculator::toInt).collect(Collectors.toList());
    }

    private static int toInt(String n) {
        int num;
        try {
            num = Integer.parseInt(n);
        } catch (Exception e) {
            throw new RuntimeException("숫자 외의 문자가 존재합니다.");
        }
        validateNegativeNumber(num);
        return num;
    }

    private static void validateNegativeNumber(int number) {
        if (number < ZERO) {
            throw new RuntimeException("음수가 존재합니다.");
        }
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .sum();
    }
}
