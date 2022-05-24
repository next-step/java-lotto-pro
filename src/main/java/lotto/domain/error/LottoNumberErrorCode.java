package lotto.domain.error;

public enum LottoNumberErrorCode {

    NOT_ALLOW_NULL("null 값을 허용하지 않습니다."),
    INVALID_LOTTO_NUMBER("허용하지 않는 로또번호입니다. %d~%d 사이의 숫자를 입력해주세요.");

    private final String message;

    LottoNumberErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
