package step3.common.exception;

public class BaseException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BaseException() {
    }

    public BaseException(String errorMessage) {
        super(errorMessage);
    }

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMsg());
        this.errorMessage = errorMessage;
    }

    public BaseException(String message, ErrorMessage errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public BaseException(String message, ErrorMessage errorMessage, Throwable cause) {
        super(message, cause);
        this.errorMessage = errorMessage;
    }
}
