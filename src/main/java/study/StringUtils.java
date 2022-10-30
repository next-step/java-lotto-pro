package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final String DELIMITER = ",|:";
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static Matcher matcher;
    public static String[] split(String text) {
        matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customToken = matcher.group(NUM_1);
            return matcher.group(NUM_2).split(customToken);
        }

        return text.split(DELIMITER);
    }

    public static int stringToInt(String num) {
        int intValue = Integer.parseInt(num);
        if(Validator.isNegativeNumber(intValue)){
            throw new IllegalArgumentException("양수값만 입력해주세요!!");
        }
        return intValue;
    }
}
