package lotto.exception;

public class InputDataException extends RuntimeException{
    private InputDataErrorCode inputDataErrorCode;
    private String errorMessage;

    public InputDataException(InputDataErrorCode inputDataErrorCode) {
        this(inputDataErrorCode, inputDataErrorCode.errorMessage());
        this.inputDataErrorCode = inputDataErrorCode;
    }

    public InputDataException(InputDataErrorCode inputDataErrorCode, String errorMessage) {
        super(errorMessage);
        this.inputDataErrorCode = inputDataErrorCode;
        this.errorMessage = errorMessage;
    }
}
