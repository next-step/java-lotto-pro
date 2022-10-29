package step3.type;

public enum ErrorMessageType {

    INPUT_NOT_ALLOW_BLANK("빈 값은 입력할 수 없습니다."),
    INPUT_NOT_ALLOW_NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    INPUT_ONLY_ALLOW_NUMBER("숫자만 입력이 가능합니다.");

    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
