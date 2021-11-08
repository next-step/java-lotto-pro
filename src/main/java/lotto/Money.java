package lotto;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public double calculateYield(Money paidMoney) {
        return Math.floor(money / (double) paidMoney.get() * 100) / 100.0;
    }

    private int get() {
        return money;
    }

    public int getNumberOfTicket(int lottoTicketUnitPrice) {
        return money / lottoTicketUnitPrice;
    }
}
