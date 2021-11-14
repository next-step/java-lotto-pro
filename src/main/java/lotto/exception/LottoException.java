package lotto.exception;

public class LottoException extends RuntimeException {
    public LottoException(LottoErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
