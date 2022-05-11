import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final Pattern DEFAULT_DELIMITER = Pattern.compile(",|:");

    private static final int CUSTOM_DELIMITER_MATCHER_GROUP = 1;
    private static final int TEXT_MATCHER_GROUP = 2;

    private static final int DEFAULT_SUM = 0;

    public static int splitAndSum(String text) {
        if (isNotNumeric(text))
            return DEFAULT_SUM;

        String[] tokens = split(text);
        return sum(tokens);
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_MATCHER_GROUP);
            return m.group(TEXT_MATCHER_GROUP).split(customDelimiter);
        }

        return text.split(String.valueOf(DEFAULT_DELIMITER));
    }

    private static int sum(String[] tokens) {
        int sum = DEFAULT_SUM;
        for (String s : tokens)
            sum += getUnsignedInt(s);

        return sum;
    }

    private static int getUnsignedInt(String token) {
        return Integer.parseUnsignedInt(token);
    }

    private static boolean isNotNumeric(String text) {
        return text == null || text.isEmpty();
    }
}
