package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Integer> splitTextTrimToInt(String text, String separator) {
        return Arrays.stream(text.split(separator))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
