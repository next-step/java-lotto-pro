package lotto.exception;

public class LottoException extends RuntimeException {

    public LottoException(final LottoExceptionType lottoExceptionType) {
        super(lottoExceptionType.getMessage());
    }

    public LottoException(final String message) {
        super(message);
    }
}
