package lotto.exception;

public class LottoStringFormatException extends NumberFormatException{

    private static final String ERROR_LOTTO_STRING_FORMAT = "[ERROR] 로또번호는 \", \"로 구분하여 숫자로만 입력해주세요.";

    public LottoStringFormatException() {
        super(ERROR_LOTTO_STRING_FORMAT);
    }
}
