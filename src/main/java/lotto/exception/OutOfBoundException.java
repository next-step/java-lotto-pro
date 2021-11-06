package lotto.exception;

public class OutOfBoundException extends IllegalArgumentException {
    private static final String VALUE_IS_LESS_THAN_EXCEPTION_STATEMENT = "값이 %d가 주어진 범위보다 작습니다.";
    private static final String VALUE_IS_GREATER_THAN_EXCEPTION_STATEMENT = "값이 %d가 주어진 범위보다 큽니다.";

    public OutOfBoundException(String message) {
        super(message);
    }

    public static OutOfBoundException valueIsLessThan(int value) {
        return new OutOfBoundException(String.format(VALUE_IS_LESS_THAN_EXCEPTION_STATEMENT, value));
    }

    public static OutOfBoundException valueIsGreaterThan(int value) {
        return new OutOfBoundException(String.format(VALUE_IS_GREATER_THAN_EXCEPTION_STATEMENT, value));
    }
}
