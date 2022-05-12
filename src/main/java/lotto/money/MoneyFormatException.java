package lotto.money;

public class MoneyFormatException extends RuntimeException {

    public MoneyFormatException(String value) {
        super(String.format("Money 형식에 어긋납니다. (입력값: %s)", value));
    }

    public MoneyFormatException(long value) {
        super(String.format("Money 형식에 어긋납니다. (입력값: %d)", value));
    }
}
