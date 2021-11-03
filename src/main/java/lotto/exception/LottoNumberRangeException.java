package lotto.exception;

public class LottoNumberRangeException extends IllegalArgumentException {
    private static final String NUMBER_RANGE_ERROR_TEXT = "로또 번호는 1부터 45까지의 숫자여야 합니다.";

    public LottoNumberRangeException() {
        super(NUMBER_RANGE_ERROR_TEXT);
    }
}
