package lotto;

import java.util.Arrays;
import java.util.Objects;

public class Sum {
    private static final String NULL_VALUE = null;
    private static final String EMPTY_VALUE = "";
    private static final int DIRECT_RETURN_VALUE = 1;

    private int sum;

    public static int splitSumValue(String text) {
        return Arrays.asList(StringSplit.splitText(text)).stream()
                .mapToInt(StringParsing::stringToIntValue)
                .sum();
    }

    public static int sumValue(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (isDirectReturn(text)) {
            return StringParsing.stringToIntValue(text);
        }

        return splitSumValue(text);
    }

    public static boolean isNullOrEmpty(String text) {
        return Objects.equals(text, NULL_VALUE) || text.equals(EMPTY_VALUE);
    }

    public static boolean isDirectReturn(String text) {
        return text.length() == DIRECT_RETURN_VALUE;
    }

    public Sum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sum sum1 = (Sum) o;
        return sum == sum1.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum);
    }
}
