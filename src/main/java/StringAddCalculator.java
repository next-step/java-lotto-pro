import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP_1 = 1;
    private static final int CUSTOM_DELIMITER_GROUP_2 = 2;

    public static int splitAndSum(String text) {
        int result = 0;
        if (text == null || text.isEmpty()) {
            return result;
        }
        String[] strings = splitString(text);

        result = addStrings(strings);
        return result;
    }

    private static int addStrings(String[] strings) {
        int result = 0;
        for (String string : strings) {
            int number = numberValidate(string);
            result += number;
        }
        return result;
    }

    private static int numberValidate(String string) throws RuntimeException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("숫자 타입이 아닙니다.");
        }
        if (number < 0) {
            throw new RuntimeException("음수는 불가입니다.");
        }
        return number;
    }

    private static String[] splitString(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP_1);
            return m.group(CUSTOM_DELIMITER_GROUP_2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITERS);
    }
}
