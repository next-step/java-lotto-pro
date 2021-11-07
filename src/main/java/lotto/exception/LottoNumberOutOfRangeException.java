package lotto.exception;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {

    private static final String LOTTO_NUMBER_RANGE_MESSAGE = "로또 숫자의 범위가 초과하였습니다.";

    public LottoNumberOutOfRangeException() {
        super(LOTTO_NUMBER_RANGE_MESSAGE);
    }

    public LottoNumberOutOfRangeException(String message) {
        super(message);
    }
}
