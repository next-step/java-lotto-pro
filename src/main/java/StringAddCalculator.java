import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(String value) {
        if (isNullOrEmpty(value)) {
            return ZERO;
        }
        return Integer.parseInt(value);
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }
}
