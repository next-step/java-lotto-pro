package lotto_auto.exception;

import lotto_auto.model.Lotto;

public class IllegalLottoException extends IllegalArgumentException {
    public static final IllegalLottoException NOT_NUMBER_ERROR = new IllegalLottoException(Lotto.NOT_NUMBER);
    public static final IllegalLottoException NOT_MATCHED_NUMBER_SIZE_ERROR = new IllegalLottoException(Lotto.NOT_MATCHED_NUMBER_SIZE);
    public static final IllegalLottoException EXIST_DUPLICATE_VALUE_ERROR = new IllegalLottoException(Lotto.EXIST_DUPLICATE_VALUE);
    public static final IllegalLottoException NOT_RANGE_NUMBER_ERROR = new IllegalLottoException(Lotto.NOT_RANGE_NUMBER);

    public IllegalLottoException(final String errorMessage) {
        super(errorMessage);
    }
}
