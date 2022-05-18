package step3.domain;


import java.util.Objects;

public class Money {

    private final int money;
    private final String MONEY_RANGE_EXCEPTION = "돈은 양수의 자연수여야 합니다";

    public Money(String money) {
        if (!validateMoney(money)) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION);
        }
        this.money = Integer.parseInt(money);
    }

    public Money(int money) {
        if (!validateMoney(money)) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION);
        }
        this.money = money;
    }

    private boolean validateMoney(String money) {
        try {
            return Integer.parseInt(money) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateMoney(int money) {
        return money >= 0;
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
