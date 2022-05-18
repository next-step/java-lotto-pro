package lotto.infrastructure.error;

public enum LottoCountErrorCode {

    NOT_ALLOW_SMALLER_THAN_ONE("lottoCount 1보다 커야 합니다.");

    private final String message;

    LottoCountErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
