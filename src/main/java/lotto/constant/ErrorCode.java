package lotto.constant;

public enum ErrorCode {

    로또의_각_자리수는_1이상_45이하("[ERROR] 로또의 각 자리수는 1이상 45이하여야 합니다."),
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
