package lotto.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringSplitter {
    private static final String DELIMITER_REGEX = "[,]";

    private StringSplitter() {}

    public static String[] split(String string) {
        if (StringUtil.isNullOrEmpty(string)) {
            return new String[]{};
        }

        return Arrays.stream(string.split(DELIMITER_REGEX))
                .map(s -> StringUtil.trim(s))
                .collect(Collectors.toList()).toArray(new String[0]);
    }
}
