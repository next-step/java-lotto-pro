package lotto.domain.exception;

public class RangeOutOfLottoNumberException extends IllegalArgumentException {

    private static final String RANGE_OUT_OF_LOTTO_NUMBER_ERROR_MESSAGE = "숫자는 1부터 45 사이여야 합니다.";

    public RangeOutOfLottoNumberException() {
        super(RANGE_OUT_OF_LOTTO_NUMBER_ERROR_MESSAGE);
    }

}
