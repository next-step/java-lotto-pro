package lotto.domain.message;

public enum ErrorMessage {
    INVALID_PAYMENT("구입금액은 1000원 단위로 입력이 가능합니다. 숫자만 입력해주세요."),
    INVALID_MANUAL_AMOUNT("수동 구매 수량은 0보다 크고 구매 가능 수량보다는 작은 수여야 합니다."),
    INVALID_LOTTO_NUMBERS("1에서 45까지의 숫자 6개를 입력주세요. 각 숫자는 컴마(,)로 구분되며 중복될 수 없습니다."),
    INVALID_BONUS_BALL("1에서 45까지의 숫자만 1개만 입력해주세요. 보너스 볼은 당첨 번호와 중복될 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
