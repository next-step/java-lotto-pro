package lotto.util;

import java.util.Objects;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }
}
