package camp.nextstep.edu.level1.lotto.lotto;

public class Money {
    private final int MIN_VALUE = 0;

    private long value;

    public Money(long value) {
        checkValidateMoney(value);
        this.value = value;
    }

    public long getAvailablePurchaseCount(long price) {
        if (price == 0) {
            return 0;
        }
        return this.value / price;
    }

    public void add(long value) {
        this.value += value;
    }

    public void sub(long value) {
        checkSubValidate(value);

        this.value -= value;
    }

    public long getValue() {
        return this.value;
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
}
