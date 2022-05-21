package lotto.domain.error;

public enum LottoResultErrorCode {

    NOT_ALLOW_NULL("null 값은 허용하지 않습니다."),
    LOTTO_COUNT_ALLOW_BIGGER_THAN_ZERO("lottoCount는 0보다 커야합니다.");

    private final String message;

    LottoResultErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}