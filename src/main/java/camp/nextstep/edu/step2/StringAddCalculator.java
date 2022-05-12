package camp.nextstep.edu.step2;

import java.util.Objects;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        if (isEmptyOrNull(input)) {
            return 0;
        }
        return new WholeNumbers(Separator.differentiate(input)).sum();
    }

    private static boolean isEmptyOrNull(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
