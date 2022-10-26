package Utils;

import java.util.regex.Pattern;

public final class PatternUtils {
    private static final Pattern positiveNumberPattern = Pattern.compile("[0-9]+");

    public static boolean isPositiveNumber(String paragraph) {
        return positiveNumberPattern.matcher(paragraph).matches();
    }
}
