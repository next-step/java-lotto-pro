package step3.domain;

import java.util.Objects;

public final class Money {
    private static final int ZERO = 0;
    private static final String MONEY_CAN_NOT_BE_NEGATIVE = "금액은 음수일 수 없습니다.";
    private final long value;

    public Money(final long value) {
        validateValueIsPositive(value);
        this.value = value;
    }

    private static void validateValueIsPositive(final long value) {
        if (value < ZERO) {
            throw new IllegalArgumentException(MONEY_CAN_NOT_BE_NEGATIVE);
        }
    }

    public boolean canBuy(final Money lottoPrice) {
        return this.value >= lottoPrice.value;
    }

    public Money pay(final Money price) {
        return new Money(this.value - price.value);
    }

    public Money multiply(final int value) {
        return new Money(this.value * value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
