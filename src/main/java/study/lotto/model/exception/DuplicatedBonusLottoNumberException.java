package study.lotto.model.exception;

public class DuplicatedBonusLottoNumberException extends IllegalArgumentException {
    public DuplicatedBonusLottoNumberException(final String message) {
        super(message);
    }
}
