package lotto.exception;

public class IllegalLottoNumberSizeException extends IllegalArgumentException {
    public IllegalLottoNumberSizeException() {
        super("로또 번호는 6개의 숫자로 구성되어야 합니다");
    }
}
