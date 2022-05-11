package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }

        List<Integer> numbers = parseInts(split(text));
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(",|:|" + customDelimiter);
        }

        return text.split(",|:");
    }

    private static List<Integer> parseInts(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            numbers.add(parseInt(split[i]));
        }

        return numbers;
    }

    private static int parseInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (!isNumeric(s)) {
            throw new IllegalArgumentException("숫자(정수 형태) 이외의 값입니다.");
        }

        int result = Integer.parseInt(s);
        if (result < 0) {
            throw new IllegalArgumentException("음수입니다.");
        }

        return result;
    }

    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
