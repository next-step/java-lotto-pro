package exception;

public enum ExceptionType {
    INVALID_EXPRESSION("잘못된 식입니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
