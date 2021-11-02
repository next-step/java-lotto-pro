package lotto.exception;

public class MyException extends RuntimeException {
    private MyErrorCode myErrorCode;
    private String errorMessage;

    public MyException(MyErrorCode myErrorCode) {
        this(myErrorCode, myErrorCode.errorMessage());
        this.myErrorCode = myErrorCode;
    }

    public MyException(MyErrorCode myErrorCode, String errorMessage) {
        super(errorMessage);
        this.myErrorCode = myErrorCode;
        this.errorMessage = errorMessage;
    }
}
