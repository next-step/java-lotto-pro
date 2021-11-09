package lotto.domain;

public class Money {
    private final int price;

    public Money(int price) {
        this.price = price;
    }

    public boolean isExceedMoney(Money manualMoney) {
        return price < manualMoney.price;
    }

    public int getPrice() {
        return price;
    }
}
