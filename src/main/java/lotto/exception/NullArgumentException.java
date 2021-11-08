package lotto.exception;

public class NullArgumentException extends IllegalArgumentException {
    private static final String NULL_ARGUMENT_EXCEPTION_STATEMENT = "주어진 인자 %s의 값이 null입니다.";

    public NullArgumentException(String argument) {
        super(String.format(NULL_ARGUMENT_EXCEPTION_STATEMENT, argument));
    }
}
