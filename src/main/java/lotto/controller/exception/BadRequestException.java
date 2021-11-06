package lotto.controller.exception;

public class BadRequestException extends RuntimeException {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public BadRequestException(final String message) {
        super(ERROR_MESSAGE_PREFIX + message);
    }
}
