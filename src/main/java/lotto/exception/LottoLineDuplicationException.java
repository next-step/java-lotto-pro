package lotto.exception;

public class LottoLineDuplicationException extends IllegalArgumentException{

    private static final String ERROR_LOTTO_DUPLICATE_NUMBER = "[ERROR] 중복된 숫자가 존재합니다.";

    public LottoLineDuplicationException() {
        super(ERROR_LOTTO_DUPLICATE_NUMBER);
    }
}
