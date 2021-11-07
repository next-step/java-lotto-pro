package lotto.domain;

public class Money {
    public static final int LOTTO_BUY_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money / LOTTO_BUY_PRICE * LOTTO_BUY_PRICE;
    }

    public int getMoney() {
        return money;
    }

    public int buyableQuantity() {
        return money / LOTTO_BUY_PRICE;
    }
    
    public boolean isBuyableMoney() {
        return money != 0;
    }
}
