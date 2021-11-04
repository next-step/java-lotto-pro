package study.lotto.model;

public class MalFormedLottoNumberException extends IllegalArgumentException {
    public MalFormedLottoNumberException(final String message) {
        super(message);
    }
}
