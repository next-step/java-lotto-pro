package lotto.exception;

public enum LottoExceptionType {
    LOTTO_LENGTH("6자리의 번호를 입력 해야 합니다."),
    LOTTO_OVERLAP("중복된 숫자는 입력 불가능 합니다."),
    LOTTO_RANGE("로또 허용 범위 값 오류(1 ~ 45)"),
    MINUS_MONEY("금액은 마이너스 입력이 불가능 합니다"),
    LOTTO_MONEY_LEAK("로또 구매 금액이 부족 합니다."),
    INPUT_NUMBER_FORMAT("로또 구입 금액 입력 오류"),
    INPUT_IO("입력 오류"),
    DUPLICATE_BONUS_NUMBER("보너스 볼의 값과 당첨번 호 값이 중복이 포함 됩니다.");

    private final String message;

    LottoExceptionType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}