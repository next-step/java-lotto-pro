package step3.common.exception;

public enum ErrorMessage {
    ERROR_INVALID_MESSAGE("잘못된 입력값이 입력되었습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMsg(Object... arg) {
        return String.format(errorMessage, arg);
    }
}

