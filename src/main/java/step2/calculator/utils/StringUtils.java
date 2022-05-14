package step2.calculator.utils;

/**
 * @author : choi-ys
 * @date : 2022/05/14 6:41 오후
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String input) {
        return isNull(input) || isEmpty(input);
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }
}
