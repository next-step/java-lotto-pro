package step3.message;

public enum ErrorMessage {
    ERR_MONEY_CAN_NOT_BE_NEGATIVE("금액은 음수일 수 없습니다."),
    ERR_LOTTO_NUMBER_OUT_OF_RANGE("로또 숫자의 범위는 1 ~ 45 이내여야 합니다."),
    ERR_LOTTO_NUMBER_CAN_NOT_DUPLICATE("로또 번호는 중복되지 않은 숫자 6자리로 이루어져야 합니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
