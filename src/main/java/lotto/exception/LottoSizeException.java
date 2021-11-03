package lotto.exception;

public class LottoSizeException extends IllegalArgumentException {
    private static final String LOTTO_SIZE_ERROR_TEXT = "로또 번호는 6개를 골라야 합니다.";

    public LottoSizeException() {
        super(LOTTO_SIZE_ERROR_TEXT);
    }
}
