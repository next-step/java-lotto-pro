package calculator.exception;

public class NotPermittedPatternException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "%s 허용되는 패턴이 아닙니다.";

    public NotPermittedPatternException(String target) {
        super(String.format(MESSAGE_FORMAT, target));
    }
}