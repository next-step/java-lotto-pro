package lotto.domain.error;

public enum LottoCountErrorCode {

    NOT_ALLOW_SMALLER_THAN_ONE("lottoCount 0 이상이여야 합니다.");

    private final String message;

    LottoCountErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
