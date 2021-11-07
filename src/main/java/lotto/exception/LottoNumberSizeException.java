package lotto.exception;

public class LottoNumberSizeException extends IllegalArgumentException {

    private static final String LOTTO_NUMBER_SIZE_MESSAGE = "로또 숫자들의 길이가 잘못됐습니다.";

    public LottoNumberSizeException() {
        super(LOTTO_NUMBER_SIZE_MESSAGE);
    }

    public LottoNumberSizeException(String message) {
        super(message);
    }

}
