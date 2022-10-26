import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String REGEX = "//(.)\n(.*)";
    private static final int EMPTY_RESULT = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return EMPTY_RESULT;
        }
    }


    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
