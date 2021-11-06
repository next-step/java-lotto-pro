package lotto;

public class LottoException extends RuntimeException {
    public LottoException(LottoErrorCode errorCode) {
        super(errorCode.makePrintableMessage());
    }
}
