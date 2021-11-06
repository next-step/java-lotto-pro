package lotto.exception;

public class InvalidInputException extends RuntimeException {

    private static final String MESSAGE = "[ERROR]잘못된 입력입니다.";

    public InvalidInputException(String appendMessage) {
        super(String.format("%s %s", MESSAGE, appendMessage));
    }

}
