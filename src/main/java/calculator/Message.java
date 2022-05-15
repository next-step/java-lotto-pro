package calculator;

public enum Message {
    ONLY_POSITIVE_NUMBER_TEXT("문자열 계산기에는 음수를 전달할 수 없습니다."),
    ONLY_NUMBER_TEXT("문자열 계산기에는 숫자 문자여야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
