import java.util.Objects;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        if (text.length() == 1) {
            return Integer.parseInt(text);
        }
        return 0;
    }
}
