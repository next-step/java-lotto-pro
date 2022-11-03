package lotto.status;

public enum ErrorStatus {
    INVALID_LOTTO_NUMBER("1~45이외의 숫자 혹은 문자열은 로또번호가 될 수 없습니다."),
    INVALID_LOTTO_COMPONENT("로또숫자의 개수가 6개가 아닙니다."),
    INVALID_MONEY_AMOUNT("금액은 음수일 수 없습니다."),
    CAN_NOT_PURCHASE_LOTTO("로또를 구매할 수 없습니다."),
    INVALID_BONUS_NUMBER("보너스볼은 당첨 로또 번호에 포함이 될 수 없습니다."),
    INVALID_PRIZES("상금 리스트들의 경우 빈 값은 들어올 수 있으나 null값은 들어올 수 없습니다.");

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
