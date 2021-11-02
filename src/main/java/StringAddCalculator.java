import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String value) {
        if (isNullOrEmpty(value)) {
            return ZERO;
        }
        return Arrays.stream(getToken(value))
                .mapToInt(Integer::parseInt)
                .peek(StringAddCalculator::checkNegative)
                .reduce(ZERO, Integer::sum);
    }

    private static void checkNegative(int value) {
        if (value < ZERO) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }

    private static String[] getToken(String value) {
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return value.split(DEFAULT_DELIMITER);
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }
}
