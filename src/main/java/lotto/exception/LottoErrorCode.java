package lotto.exception;

public enum LottoErrorCode {
    INVALID_MONEY("0 이상의 숫자를 입력해주세요."),
    INVALID_LOTTO_NUMBER("1 ~ 45 사이의 숫자를 입력해주세요."),
    INVALID_LOTTO_COUNT("로또 티켓 갯수는 양수여야 합니다."),
    INVALID_LOTTO_TICKET("1 ~ 45의 숫자 중 중복되지 않은 숫자 6개를 입력해주세요.");

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    public String makePrintableMessage() {
        return message;
    }
}
