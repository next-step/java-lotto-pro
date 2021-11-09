package lotto.exception;

public class NumberDuplicationException extends IllegalArgumentException {
    public NumberDuplicationException() {
        super("중복되는 숫자가 있습니다.");
    }
}
