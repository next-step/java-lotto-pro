import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern BASIC_PATTERN = Pattern.compile(BASIC_DELIMITER);
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String actual) {
        if(actual == null || actual.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_PATTERN.matcher(actual);

        if(matcher.find()) {
            return sum(CustomDetermiterSplit(actual));
        }

        return sum(basicDetermiterSplit(actual));
    }

    private static List<String> CustomDetermiterSplit(String number) {
        Matcher matcher = CUSTOM_PATTERN.matcher(number);
        List<String> numbersToCustomPattern = new ArrayList<>();
        List<String> results = new ArrayList<>();

        if(matcher.find()) {
            String customDeterMiterString = matcher.group(1);
            numbersToCustomPattern = Arrays.asList(matcher.group(2).split(customDeterMiterString));
        }

        for(String num : numbersToCustomPattern) {
            results.addAll(basicDetermiterSplit(num));
        }

        return results;
    }

    private static List<String> basicDetermiterSplit(String number) {
        Matcher matcher = BASIC_PATTERN.matcher(number);
        if(matcher.find())
            return Arrays.asList(matcher.group(2).split(BASIC_DELIMITER));
        return Arrays.asList(number);
    }

    private static int sum(List<String> numbers) {
        int sum = 0;
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
