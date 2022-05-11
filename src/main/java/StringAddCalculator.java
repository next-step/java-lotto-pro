import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int sum = 0;
        String[] strs;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            strs = m.group(2).split(customDelimiter);
            for (String s : strs)
                sum += Integer.parseUnsignedInt(s);

            return sum;
        }

        strs = str.split(",|:");
        for (String s : strs)
            sum += Integer.parseUnsignedInt(s);

        return sum;
    }
}
