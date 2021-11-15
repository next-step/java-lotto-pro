package lotto.exception;

public enum LottoErrorCode {
    INVALID_MONEY("0 이상의 숫자를 입력해주세요."),
    INVALID_MANUAL_COUNT("전체 개수보다 수동 입력 숫자가 더 큽니다."),
    INVALID_BALL("1 ~ 45 사이의 숫자를 입력해주세요."),
    INVALID_COUNT("로또 티켓 갯수는 양수여야 합니다."),
    INVALID_NUMBER("숫자가 아닌 값이 있습니다."),
    INVALID_TICKET("1 ~ 45의 숫자 중 중복되지 않은 숫자 6개를 입력해주세요."),
    INVALID_BONUS_BALL("지난 주 당첨 번호와 중복되지 않은 숫자를 입력해주세요.");

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
