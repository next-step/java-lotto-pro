package lotto.auto;

import java.math.BigInteger;

public class Money {
    private final int DEFAULT_MONEY = 0;
    private int money;

    public Money() {
        this.money = DEFAULT_MONEY;
    }

    public Money(String money) {
        this.money = changeStringToInt(money);
    }

    public int changeStringToInt(String money) {
        if (money == null) {
            throw new IllegalArgumentException();
        }
        if (money.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(money);
        }
        throw new IllegalArgumentException();
    }

    public int getMoney() {
        return money;
    }

    public int substractMoney(String subtract) {
        if (this.money < changeStringToInt(subtract)) {
            throw new IllegalArgumentException();
        }
        this.money = this.money - changeStringToInt(subtract);

        return this.money;
    }
}
