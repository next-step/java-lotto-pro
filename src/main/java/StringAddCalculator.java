import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty())
            return 0;

        int sum = 0;
        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
            for (String s : tokens)
                sum += Integer.parseUnsignedInt(s);

            return sum;
        }

        tokens = text.split(",|:");
        for (String s : tokens)
            sum += Integer.parseUnsignedInt(s);

        return sum;
    }
}
