package lotto.exception;

public class UnexpectValueException extends RuntimeException {

    private static final String MESSAGE = "[ERROR]오류가 발생했습니다.";

    public UnexpectValueException(String appendMessage) {
        super(String.format("%s %s", MESSAGE, appendMessage));
    }

}
