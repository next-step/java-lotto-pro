package lotto.exception;

public class NotNumberException extends NumberFormatException{

    private static final String ERROR_LOTTO_PAYMENT_NUMBER = "[ERROR] 숫자를 입력해주세요.";

    public NotNumberException() {
        super(ERROR_LOTTO_PAYMENT_NUMBER);
    }
}
