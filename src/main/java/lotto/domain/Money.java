package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    
    public int buyableQuantity() {
        return money/1000;
    }
}
