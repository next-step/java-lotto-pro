import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_IDENTIFIER_REGEX = "//(.)\n(.*)";
    public static final String EXCEPTION_MESSAGE_FOR_EXIST_NEGATIVE_NUMBER = "음수가 존재합니다.";


    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        if (isCustomDelimiter(text)) {
            return sum(getTokensByCustomDelimiter(text));
        }
        return sum(text.split(DELIMITER_REGEX));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_IDENTIFIER_REGEX).matcher(text);
        return m.find();
    }

    private static String[] getTokensByCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_IDENTIFIER_REGEX).matcher(text);
        String[] tokens = new String[0];
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return tokens;
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(i -> getNumberFromToken(i))
                .sum();
    }

    private static int getNumberFromToken(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new RuntimeException(EXCEPTION_MESSAGE_FOR_EXIST_NEGATIVE_NUMBER);
        }
        return number;
    }
}
