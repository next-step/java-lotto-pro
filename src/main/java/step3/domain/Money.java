package step3.domain;


import java.util.Objects;

public class Money {

    private final int money;
    private final String MONEY_RANGE_EXCEPTION = "돈은 양수의 자연수여야 합니다";

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(String money) {
        boolean validateResult = true;
        try {
            validateResult = Integer.parseInt(money) >= 0;
        } catch (NumberFormatException e) {
            validateResult = false;
        }

        if (validateResult == false) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION);
        }
    }

    private void validateMoney(int money) {
        if(money < 0){
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION);
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
