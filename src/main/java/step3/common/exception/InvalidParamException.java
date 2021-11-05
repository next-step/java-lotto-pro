package step3.common.exception;

public class InvalidParamException extends BaseException {
    public InvalidParamException() {
        super(ErrorMessage.ERROR_INVALID_MESSAGE);
    }

    public InvalidParamException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidParamException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
