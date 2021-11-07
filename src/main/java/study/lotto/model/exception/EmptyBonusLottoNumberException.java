package study.lotto.model.exception;

public class EmptyBonusLottoNumberException extends IllegalArgumentException {
    public EmptyBonusLottoNumberException(final String message) {
        super(message);
    }
}
