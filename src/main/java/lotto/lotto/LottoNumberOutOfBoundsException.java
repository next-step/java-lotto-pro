package lotto.lotto;

public class LottoNumberOutOfBoundsException extends RuntimeException{

    public LottoNumberOutOfBoundsException(String value) {
        super(String.format("LottoNumber 범위가 아닙니다. (입력값: %s, 허용 범위: %d~%d)",
                            value, LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE));
    }

    public LottoNumberOutOfBoundsException(int value) {
        super(String.format("LottoNumber 범위가 아닙니다. (입력값: %s, 허용 범위: %d~%d)",
                            value, LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE));
    }
}
