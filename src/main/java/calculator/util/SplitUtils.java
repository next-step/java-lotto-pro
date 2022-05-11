package calculator.util;

import java.util.Arrays;

public class SplitUtils {

    public static int[] splitToInt(String text, String separator) throws NumberFormatException {
        return Arrays.stream(text.split(separator))
                    .mapToInt(Integer::parseInt)
                    .toArray();
    }
}
