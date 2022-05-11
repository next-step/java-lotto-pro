import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNotNumericString(text))
            return 0;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return sum(m.group(2).split(customDelimiter));
        }

        return sum(text.split(",|:"));
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String s : tokens)
            sum += getUnsignedInt(s);

        return sum;
    }

    private static int getUnsignedInt(String token) {
        return Integer.parseUnsignedInt(token);
    }

    private static boolean isNotNumericString(String text) {
        return text == null || text.isEmpty();
    }
}
