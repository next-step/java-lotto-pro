package lotto.exception;

public class LottoNumberRangeException extends IllegalArgumentException{

    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final String ERROR_NUMBER_RANGE_VIOLATION = "[ERROR] 로또번호는 " + LOTTO_NUMBER_LOWER_BOUND
        + "부터 " + LOTTO_NUMBER_UPPER_BOUND + "까지로 한정됩니다.";

    public LottoNumberRangeException() {
        super(ERROR_NUMBER_RANGE_VIOLATION);
    }
}
