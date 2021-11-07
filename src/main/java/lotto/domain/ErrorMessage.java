package lotto.domain;

public enum ErrorMessage {

    LOTTO_NUMBER_BOUND_ERROR("로또 숫자는 %d~%d 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 숫자는 중복될 수 없습니다."),
    LOTTO_NUMBER_SIZE_ERROR("로또 숫자는 %d개 여야 합니다."),
    LOTTO_CALCULATOR_MANUAL_OVER_ERROR("수동 구매 로또의 수는 구매 수량보다 클 수 없습니다."),
    PURCHASE_AMOUNT_MIN_ERROR("로또 구매 금액은 %d원 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
