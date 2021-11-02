import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String SPLITTER = ",|:";

    public static int splitAndSum(String value) {
        if (isNullOrEmpty(value)) {
            return ZERO;
        }
        return Arrays.stream(value.split(SPLITTER))
                .mapToInt(Integer::parseInt)
                .reduce(ZERO, Integer::sum);
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }
}
