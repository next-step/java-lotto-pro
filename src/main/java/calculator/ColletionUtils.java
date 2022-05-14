package calculator;

import java.util.Arrays;

public class ColletionUtils {

    public static int[] toNumbers(final String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
