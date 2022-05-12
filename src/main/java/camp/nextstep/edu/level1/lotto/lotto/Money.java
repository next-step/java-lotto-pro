package camp.nextstep.edu.level1.lotto.lotto;

import java.util.Objects;

public class Money {
    private final int MIN_VALUE = 0;

    private long value;

    public Money(long value) {
        checkValidateMoney(value);
        this.value = value;
    }

    public long availablePurchaseCount(long price) {
        if (price == 0) {
            return 0;
        }
        return this.value / price;
    }

    public Money add(Money target) {
        return new Money(this.value + target.value);
    }

    public Money sub(Money target) {
        checkSubValidate(target.value);

        return new Money(this.value - target.value);
    }

    public Money mul(int multipleValue) {
        return new Money(this.value * multipleValue);
    }

    private void checkValidateMoney(long value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("금액은 양수 값이어야 합니다.");
        }
    }

    private void checkSubValidate(long value) {
        if (this.value - value < MIN_VALUE) {
            throw new IllegalArgumentException("0원 미만으로 만들 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN_VALUE, value);
    }
}
