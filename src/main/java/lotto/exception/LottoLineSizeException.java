package lotto.exception;

public class LottoLineSizeException extends IllegalArgumentException{

    private static final int LOTTO_LINE_LENGTH = 6;
    private static final String ERROR_LOTTO_LINE_LENGTH_NOT_MATCH = "[ERROR] 각 로또는 " + LOTTO_LINE_LENGTH + "개의 숫자로 구성되어야 합니다.";

    public LottoLineSizeException() {
        super(ERROR_LOTTO_LINE_LENGTH_NOT_MATCH);
    }
}
