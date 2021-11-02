package calculator;

public enum ErrorMessage {

    TOKEN_ERROR("숫자만 입력할 수 있습니다."),
    NUMBER_ERROR("음수는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
