package lotto.infrastructure.error;

public enum LottoTicketErrorCode {

    NOT_ALLOW_NULL_OR_EMPTY("로또번호가 null 또는 empty입니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또번호 갯수가 잘못되었습니다. size = %d"),
    NOT_ALLOW_DUPLICATE("로또번호가 중복되었습니다."),
    INVALID_LOTTO_NUMBER("허용하지 않는 로또번호입니다. %d~%d 사이의 숫자를 입력해주세요.");

    private final String message;

    LottoTicketErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
