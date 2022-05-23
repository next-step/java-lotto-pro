package step3.domain;


import java.util.Objects;
import step3.utls.NumberUtil;

public class Money {

    private final int money;
    private static final String MONEY_RANGE_EXCEPTION = "돈은 양수의 자연수여야 합니다";
    private static final int MONEY_BOTTOM_BOUNDARY = 0;

    public Money(String money) {
        this(NumberUtil.parseInt(money));
    }

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < Money.MONEY_BOTTOM_BOUNDARY) {
            throw new IllegalArgumentException(Money.MONEY_RANGE_EXCEPTION);
        }
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
