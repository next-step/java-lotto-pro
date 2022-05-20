package step3.utls;

public class NumberUtil {

    private static final String PARSE_INT_ERROR = "숫자를 입력해야합니다";

    public static int parseInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_INT_ERROR);
        }

    }

}
