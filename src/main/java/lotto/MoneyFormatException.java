package lotto;

import java.math.BigDecimal;

public class MoneyFormatException extends RuntimeException {

    public MoneyFormatException(BigDecimal value) {
        super(String.format("Money 형식에 어긋납니다. (입력값: %s)", value));
    }
}
