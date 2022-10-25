package calculator;

public class MessageConstant {
    public static final String INVALID_NUMBER = "유효하지 않은 값이 입력되었습니다.";
    public static final String UTILITY_CLASS = "Utility Class";

    private MessageConstant() {
        throw new IllegalStateException(UTILITY_CLASS);
    }
}
