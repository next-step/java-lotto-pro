package lotto.infrastructure.util;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    public static boolean isPositiveNumber(String str) {
        return Pattern.matches("^[0-9]*$", str);
    }

    public static String[] splitAndTrim(String str, String splitRegex) {
        if (Objects.isNull(str)) {
            return new String[]{};
        }

        return str.replaceAll("\\s", "")
                .split(splitRegex);
    }

    public static List<Integer> convertIntegers(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
