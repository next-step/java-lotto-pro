package step2;

public enum ErrorMessage {
    ERROR_NOT_POSITIVE_NUMBER("양의 정수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
