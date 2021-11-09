package lotto.exception;

public class IllegalLottoNumberException extends IllegalArgumentException {
    public IllegalLottoNumberException() {
        super("1 이상 45 이하의 숫자를 입력해주세요");
    }
}
