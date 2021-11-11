package lotto.exception;

import java.util.InputMismatchException;

public class NotANumberException extends InputMismatchException {
    public NotANumberException() {
        super("정수를 입력해주세요");
    }
}
