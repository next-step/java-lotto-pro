import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        return Arrays
                .stream(text.split(",|:"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
