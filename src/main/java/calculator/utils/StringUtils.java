package calculator.utils;

/**
 * @author : choi-ys
 * @date : 2022/05/13 10:52 오전
 */
public class StringUtils {
    public static final int ZERO = 0;

    public static int processNotExistDelimiterAndEmptyString(String input) {
        return ZERO;
    }

    public static int processNotExistDelimiterString(String input) {
        return Integer.parseInt(input);
    }
}
