package lotto.domain.exception;

public class DuplicateOfLottoNumberException extends IllegalArgumentException {

    private static final String DUPLICATE_OF_LOTTO_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";

    public DuplicateOfLottoNumberException() {
        super(DUPLICATE_OF_LOTTO_NUMBER_ERROR_MESSAGE);
    }

}
