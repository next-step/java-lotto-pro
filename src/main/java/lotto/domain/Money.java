package lotto.domain;

public class Money {
    public static final int LOTTO_TICKET_PRICE = 1000;

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
