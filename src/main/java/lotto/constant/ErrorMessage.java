package lotto.constant;

public class ErrorMessage {
    private static final String ERROR_HEAD = "[ERROR] ";

    public static final String LACK_MONEY = ERROR_HEAD + "로또 최소 가격은 1000원 입니다.";
    public static final String OVER_MONEY = ERROR_HEAD + "로또 구매 최대 가격은 10_000_000원 입니다.";
    public static final String CONSTANT_CLASS = "Constant class";

    private ErrorMessage() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }
}
