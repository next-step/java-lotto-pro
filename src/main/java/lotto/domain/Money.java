package lotto.domain;

public class Money {
    private final int price;

    private Money(int price) {
        this.price = price;
    }

    public static Money of(int price) {
        return new Money(price);
    }

    public static Money of(int manualAmount, Money minimumTicketPrice) {
        return new Money(manualAmount * minimumTicketPrice.price);
    }

    public boolean isExceedMoney(Money manualMoney) {
        return price > manualMoney.price;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount(Money baseMoney) {
        return price / baseMoney.price;
    }
}
