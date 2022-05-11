package calculator.util;

import java.util.Arrays;

public class StringUtils {

    private StringUtils() {

    }

    public static boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }

    public static int[] splitToInt(String text, String separator) throws NumberFormatException {
        return Arrays.stream(text.split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
