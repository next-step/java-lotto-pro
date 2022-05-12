package lotto.lotto;

public class LottoNumberFormatException extends RuntimeException {

    public LottoNumberFormatException(String value) {
        super(String.format("LottoNumber 형식에 어긋납니다. (입력값: %s, 허용 값: %d~%d)",
                            value, LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE));
    }
}
