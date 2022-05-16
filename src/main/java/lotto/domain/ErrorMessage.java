package lotto.domain;

public enum ErrorMessage {
    INVALID_PAYMENT("구입금액은 1000원 단위로 입력이 가능합니다. 숫자만 입력해주세요."),
    INVALID_LOTTO_NUMBERS("1에서 45까지의 숫자 6개를 입력주세요. 각 숫자는 컴마(,)로 구분됩니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
