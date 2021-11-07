package study.lotto.model.exception;

public class MalFormedLottoNumberException extends IllegalArgumentException {
    public MalFormedLottoNumberException(final String message) {
        super(message);
    }
}
