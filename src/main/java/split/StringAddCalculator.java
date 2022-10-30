package split;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final List<String> defaultDelimiters = List.of(",", ":");
    private static final Pattern regex = Pattern.compile("//(.)\n(.*)");
    public static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if (validateText(text)) {
            return DEFAULT_VALUE;
        }
        Delimiters delimiters = new Delimiters(defaultDelimiters);
        if (!existCustomDelimiter(text)) {
            return sum(text, delimiters.join());
        }
        delimiters.add(extractCustomDelimiter(text));
        return sum(extractText(text), delimiters.join());
    }

    private static boolean validateText(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static int sum(String text, String delimiters) {
        validateNegativeNumber(text, delimiters);
        int sum = 0;
        for (String splitText : text.split(delimiters)) {
            sum += Integer.parseInt(splitText);
        }
        return sum;
    }

    private static void validateNegativeNumber(String text, String delimiters) {
        for (String number : text.split(delimiters)) {
            validateNegativeNumber(number);
        }
    }

    private static void validateNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean existCustomDelimiter(String text) {
        Matcher m = regex.matcher(text);
        return m.find();
    }

    private static String extractCustomDelimiter(String text) {
        Matcher m = regex.matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        throw new IllegalArgumentException("커스텀구분자가 없습니다.");
    }

    private static String extractText(String text) {
        Matcher m = regex.matcher(text);
        if (m.find()) {
            return m.group(2);
        }
        throw new IllegalArgumentException("커스텀구분자가 없습니다.");
    }
}
