package lotto.util;

import java.util.regex.Pattern;

public class RegexUtil {
    public static boolean match(String regex, String str) {
        return Pattern.matches(regex, str);
    }
}
