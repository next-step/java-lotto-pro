package camp.nextstep.edu.level1.lotto.lotto;

public class Money {
    private final int MIN_VALUE = 0;

    private int value;

    public Money(int value) {
        checkValidateMoney(value);
        this.value = value;
    }

    public int getAvailablePurchaseCount(int price) {
        if (price == 0) {
            return 0;
        }
        return this.value / price;
    }

    private void checkValidateMoney(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("금액은 양수 값이어야 합니다.");
        }
    }

    public void sub(int value) {
        this.value -= value;
    }
}
