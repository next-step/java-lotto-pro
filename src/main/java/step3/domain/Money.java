package step3.domain;

import java.util.Objects;
import util.Numbers;

public class Money {
    public static final int THOUSAND_ONE = 1000;

    private int money;

    public Money(final int money) {
        verifyMoney(money);

        this.money = money;
    }

    private void verifyMoney(final int money) {
        if (Numbers.isNegative(money)) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
        }
    }

    public int get() {
        return this.money;
    }

    public int changeUnit() {
        return Math.floorDiv(this.money, THOUSAND_ONE);
    }

    public void earn(final Money money) {
        this.money += money.get();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        final Money money1 = (Money)o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
