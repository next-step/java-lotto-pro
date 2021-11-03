package lotto.domain.exception;

public class CountOfLottoNumberException extends IllegalArgumentException {

    private static final String COUNT_OF_LOTTO_NUMBER_ERROR_MESSAGE = "숫자가 6개가 아닙니다.";

    public CountOfLottoNumberException() {
        super(COUNT_OF_LOTTO_NUMBER_ERROR_MESSAGE);
    }

}
